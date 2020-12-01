package com.alexshuvaev.wildlifesanctuary.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RootService<T> {
    List<T> getAll(Pageable pageRequest);
    T get(int id);
    T create(T creatable);
    T update(T updatable, int id);
    Boolean delete(int id);

}
