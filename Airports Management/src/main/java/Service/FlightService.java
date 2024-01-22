package Service;

import Model.Flight;

import java.util.List;

public interface FlightService {

    void addFlight(Flight flight);

//    List<Flight> getAllFlights();

    List<Flight> getAllFlights();

    Flight getFlightById(Long id);

    List<Flight> getFlightsByDepartureAirportCode(String departureAirportCode);

    List<Flight> getFlightsByDestinationAirportCode(String destinationAirportCode);

    void updateFlight(Flight flight);

    void deleteFlightById(Long id);
}
