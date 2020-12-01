package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlifesanctuary.entity.Territory;
import com.alexshuvaev.wildlifesanctuary.repository.RootRepository;
import com.alexshuvaev.wildlifesanctuary.utils.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static com.alexshuvaev.wildlifesanctuary.service.util.TestData.territory1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(value = "test", profiles = "test")
class TerritoryServiceTest {


    @Mock
    RootRepository<Territory> repository;

    @InjectMocks
    TerritoryService service;

    @Test
    void get() {
        // given
        when(repository.findById(1)).thenReturn(java.util.Optional.of(territory1));
        Territory territory = service.get(1);
        // than
        assertEquals(territory1, territory);
        verify(repository, times(1)).findById(1);
    }

    @Test
    void get_NotFoundException() {
        // given
        when(repository.findById(999)).thenReturn(Optional.empty());
        // than
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> service.get(999));
        assertEquals("no data with id=999", notFoundException.getMessage());
        verify(repository, times(1)).findById(999);
    }

    @Test
    void create() {
        // given
        when(repository.save(any())).thenReturn(territory1);
        // than
        Territory territory = service.create(territory1);
        assertEquals(territory1, territory);
        verify(repository, times(1)).save(territory1);
    }

    @Test
    void update() {
        // given
        Territory updatedTerritory1 = new Territory("New Name", "areaCode1", new BigDecimal("100.50"), "Person1", "+312345", Collections.emptyList());
        updatedTerritory1.setId(1);

        when(repository.findById(1)).thenReturn(Optional.of(territory1));
        when(repository.save(any())).thenReturn(updatedTerritory1);

        // than
        Territory territory = service.update(updatedTerritory1, 1);
        assertEquals("New Name", territory.getName());
        verify(repository, times(1)).save(updatedTerritory1);
        verify(repository, times(1)).findById(1);
    }
}