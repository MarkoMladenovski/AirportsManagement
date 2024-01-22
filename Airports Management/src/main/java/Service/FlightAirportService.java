package Service;

import Model.Airport;
import Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FlightAirportService {

//    void readAirportsFromCSV(MultipartFile file);
//
//    void readFlightsFromCSV(MultipartFile file);
//
//    List<Airport> getAllAirports();
//
//    List<Flight> getAllFlights();

    private final FlightService flightService;
    private final AirportService airportService;

    @Autowired
    public FlightAirportService(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    public void addFlightAndAirports(Flight flight, Airport departureAirport, Airport destinationAirport) {
        airportService.addAirport(departureAirport);

        // Save destination airport
        airportService.addAirport(destinationAirport);

        // Set departure and destination airports for the flight
        flight.setDepartureAirport(departureAirport);
        flight.setDestinationAirport(destinationAirport);

        // Save the flight
        flightService.addFlight(flight);
    }


    public List<Flight> getAllFlightsWithAirports() {
        List<Flight> flights = flightService.getAllFlights();

        flights.forEach(flight -> {
            Airport departureAirport = airportService.getAirportByCode(flight.getDepartureAirportCode());
            Airport destinationAirport = airportService.getAirportByCode(flight.getDestinationAirportCode());

            flight.setDepartureAirport(departureAirport);
            flight.setDestinationAirport(destinationAirport);
        });

        return flights;
    }


    public void updateFlightAndAirports(Long flightId, Flight updatedFlight,
                                        Airport updatedDepartureAirport, Airport updatedDestinationAirport) {

        airportService.updateAirport(updatedDepartureAirport);

        airportService.updateAirport(updatedDestinationAirport);

        updatedFlight.setDepartureAirport(updatedDepartureAirport);
        updatedFlight.setDestinationAirport(updatedDestinationAirport);

        flightService.updateFlight(updatedFlight);
    }

    public void deleteAirportByCode(String code) {
    }

    public void addFlightAndAirport(Flight flight, Airport departureAirport, Airport destinationAirport) {
    }

    public List<Flight> getAllFlights() {
        return null;
    }

    public Flight getFlightById(Long id) {
        return null;
    }

    public List<Flight> getFlightsByDepartureAirportCode(String departureAirportCode) {
        return null;
    }

    public List<Flight> getFlightsByDestinationAirportCode(String destinationAirportCode) {
        return null;
    }
}
