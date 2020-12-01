package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import com.alexshuvaev.wildlifesanctuary.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService extends AbstractService<Animal> implements RootService<Animal> {

    @Autowired
    public AnimalService(@Qualifier("animalRepository") RootRepository<Animal> repository) {
        super(repository);
    }

    @Override
    public List<Animal> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public Animal get(int id) {
        return super.get(id);
    }

    @Override
    public Animal create(Animal creatable) {
        return super.create(creatable);
    }

    @Override
    public Animal update(Animal updatable, int id) {
        return super.update(updatable, id);
    }

    @Override
    public Boolean delete(int id) {
        return super.delete(id);
    }
}
