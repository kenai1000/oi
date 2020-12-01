package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlifesanctuary.entity.AnimalType;
import com.alexshuvaev.wildlifesanctuary.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalTypeService extends AbstractService<AnimalType> implements RootService<AnimalType> {

    @Autowired
    public AnimalTypeService(@Qualifier("animalTypeRepository") RootRepository<AnimalType> repository) {
        super(repository);
    }

    @Override
    public List<AnimalType> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public AnimalType get(int id) {
        return super.get(id);
    }

    @Override
    public AnimalType create(AnimalType creatable) {
        return super.create(creatable);
    }

    @Override
    public AnimalType update(AnimalType updatable, int id) {
        return super.update(updatable, id);
    }

    @Override
    public Boolean delete(int id) {
        return super.delete(id);
    }
}
