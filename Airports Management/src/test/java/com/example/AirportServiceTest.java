package com.example;

import Model.Airport;
import Repository.AirportRepository;
import Service.AirportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @Test
    public void testGetAirportsByCity() {
        String city = "TestCity";
        List<Airport> mockAirports = Arrays.asList(new Airport(), new Airport());

        when(airportRepository.findByCity(city)).thenReturn(mockAirports);


        List<Airport> result = airportService.getAirportsByCity(city);

        verify(airportRepository, times(1)).findByCity(city);

        assertNotNull(result);
        assertEquals(2, result.size());
        // Add more assertions based on your specific scenario
    }

    @Test
    public void testGetAirportByCode() {
        String airportCode = "TestCode";
        Airport mockAirport = new Airport();

        when(airportRepository.findByCode(airportCode)).thenReturn(mockAirport);

        Airport result = airportService.getAirportByCode(airportCode);

        verify(airportRepository, times(1)).findByCode(airportCode);

        assertNotNull(result);
    }
}
