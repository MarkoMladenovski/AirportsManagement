package Service;

import Model.Flight;
import Repository.FlightRepository;
import Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> getFlightsByDepartureAirportCode(String departureAirportCode) {
        return flightRepository.findByDepartureAirportCode(departureAirportCode);
    }

    @Override
    public List<Flight> getFlightsByDestinationAirportCode(String destinationAirportCode) {
        return flightRepository.findByDestinationAirportCode(destinationAirportCode);
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

}
