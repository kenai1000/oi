package com.alexshuvaev.wildlifesanctuary.rest;

import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import com.alexshuvaev.wildlifesanctuary.service.RootService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/animal")
public class AnimalController extends AbstractController<Animal> {

    @Autowired
    public AnimalController(RootService<Animal> service) {
        super(service);
    }

    @ApiOperation(value = "Find all Animal entities", notes = "Find all Animal entities from DB.")
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<Animal>> getAll(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        return super.getAll(page, size);
    }

    @ApiOperation(value = "Find Animal entity by id", notes = "Provide an id to get single Animal entity from DB")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Animal> get(@PathVariable int id) {
        return super.get(id);
    }

    @ApiOperation(value = "Create single Animal entity", notes = "Provide data for new Animal entity. Only single Animal entity can be create in request.")
    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<Animal> create(@RequestBody Animal creatable) {
        return super.create(creatable);
    }

    @ApiOperation(value = "Update name of single Animal entity", notes = "Provide data for updating Animal entity. Only single Animal entity can be updated in request.")
    @Override
    @PutMapping(value = "/{id}")
    public ResponseEntity<Animal> update(@RequestBody Animal updatable, @PathVariable int id) {
        return super.update(updatable, id);
    }

    @ApiOperation(value = "Delete Animal entity", notes = "Provide an id of Animal entity, which must be deleted.")
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Animal> delete(@PathVariable int id) {
        return super.delete(id);
    }
}
