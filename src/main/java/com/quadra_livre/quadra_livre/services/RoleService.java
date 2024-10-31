package com.quadra_livre.quadra_livre.services;

import com.google.common.base.Preconditions;
import com.quadra_livre.quadra_livre.models.Role;
import com.quadra_livre.quadra_livre.repositories.RoleRepository;
import com.quadra_livre.quadra_livre.services.templates.ServiceCrudTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements ServiceCrudTemplate<Role> {

    private final RoleRepository repository;

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role delete(Long id) {
        Role role = getBy(id);
        repository.delete(role);
        return role;
    }

    @Override
    public Role getBy(Long id) {
        var optionalRole = repository.findById(id);
        return optionalRole.orElseThrow(() ->
                new NullPointerException("Nenhum perfil encontrado com o ID: " + id));
    }

    @Override
    public List<Role> list(Pageable pageable) {
        Page<Role> rolePage = repository.findAll(pageable);
        return rolePage.getContent();
    }

}
