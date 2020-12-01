package com.alexshuvaev.wildlifesanctuary.rest;

import com.alexshuvaev.wildlifesanctuary.entity.AnimalType;
import com.alexshuvaev.wildlifesanctuary.service.RootService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/animalType")
public class AnimalTypeController extends AbstractController<AnimalType> {

    @Autowired
    public AnimalTypeController(RootService<AnimalType> service) {
        super(service);
    }

    @ApiOperation(value = "Find all AnimalType entities", notes = "Find all AnimalType entities from DB.")
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<AnimalType>> getAll(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return super.getAll(page, size);
    }

    @ApiOperation(value = "Find AnimalType entities by id", notes = "Provide an id to get single AnimalType entities from DB")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AnimalType> get(@PathVariable int id) {
        return super.get(id);
    }

    @ApiOperation(value = "Create single AnimalType entity", notes = "Provide data for new AnimalType entity. Only single AnimalType entity can be create in request.")
    @Override
    @PostMapping("/add")
    public ResponseEntity<AnimalType> create(@RequestBody AnimalType creatable) {
        return super.create(creatable);
    }

    @ApiOperation(value = "Update name of single AnimalType entity", notes = "Provide data for updating AnimalType entity. Only single AnimalType entity can be updated in request.")
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AnimalType> update(@RequestBody AnimalType updatable, @PathVariable int id) {
        return super.update(updatable, id);
    }

    @ApiOperation(value = "Delete AnimalType entity", notes = "Provide an id of AnimalType entity, which must be deleted.")
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<AnimalType> delete(@PathVariable int id) {
        return super.delete(id);
    }
}
