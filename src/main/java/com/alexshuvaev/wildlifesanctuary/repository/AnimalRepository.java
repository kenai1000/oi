package com.alexshuvaev.wildlifesanctuary.repository;

import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends RootRepository<Animal> {
    @Query("SELECT a FROM Animal a JOIN a.animalType at JOIN a.territory ")
    @Override
    Page<Animal> findAll(Pageable pageable);
}
