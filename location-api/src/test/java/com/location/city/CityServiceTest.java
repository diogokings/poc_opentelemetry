package com.location.city;

import com.location.common.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    private CityService cityService;

    @BeforeEach
    void setup() {
        cityService = new CityService();
    }

    @Test
    @DisplayName("Service: Fail when city not found")
    void findById_givenNullId_whenTryToFindCity_thenThrowException() {
        String expectedErrorMessage = "ERROR: City not found! PARAMETERS: [id=null].";

        String actualErrorMessage = assertThrows(ObjectNotFoundException.class,
                () -> cityService.findById(null)).getMessage();

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    @DisplayName("Service: Success when city found")
    void findById_givenValidId_whenTryToFindCity_thenReturnIt() {
        CityDTO city = cityService.findById(1L);

        assertEquals(1L, city.getId());
        assertEquals("São Paulo", city.getName());
        assertEquals("SP", city.getState());
    }

}
