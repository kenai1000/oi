package com.alexshuvaev.wildlifesanctuary.rest;

import com.alexshuvaev.wildlifesanctuary.dto.TerritoryDto;
import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import com.alexshuvaev.wildlifesanctuary.entity.Territory;
import com.alexshuvaev.wildlifesanctuary.service.RootService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alexshuvaev.wildlifesanctuary.utils.ToTerritoryDto.territoryDtoListCreate;

@RestController
@RequestMapping(value = "/api/v1/territory")
public class TerritoryController extends AbstractController<Territory> {

    private final RootService<Animal> animalService;

    @Autowired
    public TerritoryController(RootService<Territory> service, RootService<Animal> animalService) {
        super(service);
        this.animalService = animalService;
    }

    @ApiOperation(value = "Find all Territory entities", notes = "Find all Territory entities from DB.")
    @GetMapping(value = "/list")
    public ResponseEntity<List<TerritoryDto>> getAllWithPopulation(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        List<Territory> territories = super.getAll(page, size).getBody();
        List<Animal> animals = animalService.getAll(Pageable.unpaged());
        List<TerritoryDto> territoryDtoList = territoryDtoListCreate(territories, animals);
        return new ResponseEntity<>(territoryDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "Find Territory entity by id", notes = "Provide an id to get single Territory entity from DB")
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Territory> get(@PathVariable int id) {
        return super.get(id);
    }

    @ApiOperation(value = "Create single Territory entity", notes = "Provide data for new Territory entity. Only single Territory entity can be create in request.")
    @Override
    @PostMapping("/add")
    public ResponseEntity<Territory> create(@RequestBody Territory creatable) {
        return super.create(creatable);
    }

    @ApiOperation(value = "Update name of single Territory entity", notes = "Provide data for updating Territory entity. Only single Territory entity can be updated in request.")
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Territory> update(@RequestBody Territory updatable, @PathVariable int id) {
        return super.update(updatable, id);
    }

    @ApiOperation(value = "Delete Territory entity", notes = "Provide an id of Territory entity, which must be deleted.")
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Territory> delete(@PathVariable int id) {
        return super.delete(id);
    }
}
