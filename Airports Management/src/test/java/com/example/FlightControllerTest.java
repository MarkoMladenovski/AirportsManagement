package com.example;

import Controller.FlightController;
import Model.Flight;
import Service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    @Test
    public void testAddFlight() {
        Flight testFlight = new Flight();

        doNothing().when(flightService).addFlight(testFlight);

        ResponseEntity<Void> response = flightController.addFlight(testFlight);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(flightService, times(1)).addFlight(testFlight);
    }
}
