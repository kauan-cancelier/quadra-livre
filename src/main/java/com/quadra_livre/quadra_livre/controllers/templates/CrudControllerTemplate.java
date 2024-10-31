package com.quadra_livre.quadra_livre.controllers.templates;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CrudControllerTemplate<T> {

    ResponseEntity<T> create(@RequestBody T t);

    ResponseEntity<T> update(@PathVariable("id") Long id, @RequestBody T t);

    ResponseEntity<T> delete(@PathVariable("id") Long id);

    ResponseEntity<T> getBy(@PathVariable("id") Long id);

}
