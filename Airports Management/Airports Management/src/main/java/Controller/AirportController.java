package Controller;

import Model.Airport;
import Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public void addAirport(@RequestBody Airport airport) {
        airportService.addAirport(airport);
    }

    @GetMapping("/{code}")
    public Airport getAirportByCode(@PathVariable String code) {
        return airportService.getAirportByCode(code);
    }

    @GetMapping("/country/{country}")
    public List<Airport> getAirportsByCountry(@PathVariable String country) {
        return airportService.getAirportsByCountry(country);
    }

    @GetMapping("/city/{city}")
    public List<Airport> getAirportsByCity(@PathVariable String city) {
        return airportService.getAirportsByCity(city);
    }

    @GetMapping("/name/{name}")
    public List<Airport> getAirportsByName(@PathVariable String name) {
        return airportService.getAirportsByName(name);
    }

    @GetMapping("/minRunways/{minRunways}")
    public List<Airport> getAirportsWithMinRunways(@PathVariable int minRunways) {
        return airportService.getAirportsWithMinRunways(minRunways);
    }

    @PutMapping("/{code}")
    public void updateAirport(@PathVariable String code, @RequestBody Airport airport) {
        airportService.updateAirport(airport);
    }

    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code) {
        airportService.deleteAirportByCode(code);
    }
}
