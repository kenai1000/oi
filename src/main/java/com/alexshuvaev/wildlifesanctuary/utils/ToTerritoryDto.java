package com.alexshuvaev.wildlifesanctuary.utils;

import com.alexshuvaev.wildlifesanctuary.dto.TerritoryDto;
import com.alexshuvaev.wildlifesanctuary.entity.Animal;
import com.alexshuvaev.wildlifesanctuary.entity.Territory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ToTerritoryDto {

    private ToTerritoryDto() {
    }

    public static List<TerritoryDto> territoryDtoListCreate(final List<Territory> territories, final List<Animal> animals){
        return territories.stream()
                .map(territory -> territoryDtoCreate(territory, animals)).collect(Collectors.toList());
    }

    private static TerritoryDto territoryDtoCreate(final Territory territory, final List<Animal> animals ) {
        Map<String, Long> populationGroupAnimalsCountMap = animals.stream()
                .collect(Collectors.groupingBy(
                        animal -> animal.getAnimalType().getPopulationsGroup().getName(),
                        Collectors.filtering(
                                animal -> animal.getTerritory().getId().equals(territory.getId()), Collectors.counting()
                        )
                ));
        return new TerritoryDto(
                territory.getId(),
                territory.getName(),
                territory.getAreaCode(),
                territory.getSquare(),
                territory.getPerson(),
                territory.getPhone(),
                populationGroupAnimalsCountMap);
    }
}
