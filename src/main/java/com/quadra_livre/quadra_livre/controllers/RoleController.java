package com.quadra_livre.quadra_livre.controllers;

import com.quadra_livre.quadra_livre.controllers.templates.CrudControllerTemplate;
import com.quadra_livre.quadra_livre.models.Role;
import com.quadra_livre.quadra_livre.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController implements CrudControllerTemplate<Role> {

    private final RoleService service;

    @Override
    @PostMapping
    public ResponseEntity<Role> create(Role role) {
        Role savedRole = service.save(role);
        return ResponseEntity.status(201).body(savedRole);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Role> update(Long id, Role role) {
        Role existingRole = service.getBy(id);
        Role editedRole = service.save(existingRole);
        return ResponseEntity.ok().body(editedRole);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Role> getBy(Long id) {
        Role role = service.getBy(id);
        return ResponseEntity.ok(role);
    }

}
