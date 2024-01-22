package com.example;

import Controller.AirportController;
import Model.Airport;
import Service.AirportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class AirportControllerTest {

    @Mock
    private AirportService airportService;

    @InjectMocks
    private AirportController airportController;

    @Test
    public void testGetAirportsByCountry() {
        String country = "TestCountry";
        List<Airport> mockAirports = Arrays.asList(new Airport(), new Airport());

        when(airportService.getAirportsByCountry(country)).thenReturn(mockAirports);

        ResponseEntity<List<Airport>> responseEntity = (ResponseEntity<List<Airport>>) airportController.getAirportsByCountry(country);

        verify(airportService, times(1)).getAirportsByCountry(country);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(2, responseEntity.getBody().size());
    }
}
