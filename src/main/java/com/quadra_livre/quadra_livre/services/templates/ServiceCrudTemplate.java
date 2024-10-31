package com.quadra_livre.quadra_livre.services.templates;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceCrudTemplate<T> {

    T save(T object);

    T delete(Long id);

    T getBy(Long id);

    List<T> list(Pageable pageable);
}
