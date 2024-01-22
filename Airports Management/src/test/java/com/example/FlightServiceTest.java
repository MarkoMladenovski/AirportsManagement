package com.example;

import Model.Flight;
import Repository.FlightRepository;
import Service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testGetFlightsByDepartureAirportCode() {
        String departureAirportCode = "TestDepartureCode";
        List<Flight> mockFlights = Arrays.asList(new Flight(), new Flight());

        when(flightRepository.findByDepartureAirportCode(departureAirportCode)).thenReturn(mockFlights);


        List<Flight> result = flightService.getFlightsByDepartureAirportCode(departureAirportCode);

        verify(flightRepository, times(1)).findByDepartureAirportCode(departureAirportCode);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
    }
}
