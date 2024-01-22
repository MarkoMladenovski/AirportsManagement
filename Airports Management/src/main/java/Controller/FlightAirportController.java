package Controller;

import DTO.FlightAirportRequest;
import Service.FlightAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights-and-airports")
public class FlightAirportController {

    private final FlightAirportService flightAirportService;

    @Autowired
    public FlightAirportController(FlightAirportService flightAirportService) {
        this.flightAirportService = flightAirportService;
    }

    @PostMapping("/addFlightAndAirports")
    public void addFlightAndAirports(@RequestBody FlightAirportRequest request) {
        flightAirportService.addFlightAndAirport(
                request.getFlight(),
                request.getDepartureAirport(),
                request.getDestinationAirport()
        );
    }

}
