package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlifesanctuary.entity.AbstractEntity;
import com.alexshuvaev.wildlifesanctuary.repository.RootRepository;
import com.alexshuvaev.wildlifesanctuary.utils.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractService<T extends AbstractEntity> {

    private final RootRepository<T> repository;

    public AbstractService(RootRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> getAll(Pageable pageRequest) {
        return repository.findAll(pageRequest).stream()
                .sorted(Comparator.comparingInt(AbstractEntity::getId))
                .collect(Collectors.toList());
    }

    public T get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("no data with id=" + id));
    }

    public T create(T creatable) {
        return repository.save(creatable);
    }

    public T update(T updatable, int id) {
        AbstractEntity obj = get(id);
        updatable.setId(obj.getId());
        return repository.save(updatable);
    }

    public Boolean delete(int id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException("Cant be deleted. No data with id=" + id);
        }
        return true;
    }

}
