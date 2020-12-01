package com.alexshuvaev.wildlifesanctuary.repository;

import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends RootRepository<Animal> {
}
