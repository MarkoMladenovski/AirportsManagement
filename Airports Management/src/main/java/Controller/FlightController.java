package Controller;

import Model.Flight;
import Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Configuration
//@ComponentScan(basePackages = "Controller")
@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
        return null;
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/departure/{departureAirportCode}")
    public List<Flight> getFlightsByDepartureAirportCode(@PathVariable String departureAirportCode) {
        return flightService.getFlightsByDepartureAirportCode(departureAirportCode);
    }

    @GetMapping("/destination/{destinationAirportCode}")
    public List<Flight> getFlightsByDestinationAirportCode(@PathVariable String destinationAirportCode) {
        return flightService.getFlightsByDestinationAirportCode(destinationAirportCode);
    }

    @PutMapping("/{id}")
    public void updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        flightService.updateFlight(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlightById(id);
    }
}