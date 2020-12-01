package com.alexshuvaev.wildlifesanctuary.rest;

import com.alexshuvaev.wildlifesanctuary.entity.AbstractEntity;
import com.alexshuvaev.wildlifesanctuary.service.RootService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController<T extends AbstractEntity> {

    private final RootService<T> service;

    public AbstractController(RootService<T> service) {
        this.service = service;
    }

    public ResponseEntity<List<T>> getAll(Integer page, Integer size) {
        if (page == null && size == null) {
            return new ResponseEntity<>(service.getAll(Pageable.unpaged()), HttpStatus.OK);
        } else if (page == null) {
            return new ResponseEntity<>(service.getAll(PageRequest.of(0, size)), HttpStatus.OK);
        } else if (size == null) {
            return new ResponseEntity<>(service.getAll(PageRequest.of(page, Integer.MAX_VALUE)), HttpStatus.OK);
        }

        return new ResponseEntity<>(service.getAll(PageRequest.of(page, size)), HttpStatus.OK);
    }

    public ResponseEntity<T> get(int id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    public ResponseEntity<T> create(T creatable) {
        return new ResponseEntity<>(service.create(creatable), HttpStatus.CREATED);
    }

    public ResponseEntity<T> update(T updatable, int id) {
        return new ResponseEntity<>(service.update(updatable, id), HttpStatus.OK);
    }

    public ResponseEntity<T> delete(int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
