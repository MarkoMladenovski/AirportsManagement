package Service;

import Model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Repository.AirportJpaRepository;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportJpaRepository airportJpaRepository;

    @Autowired
    public AirportServiceImpl(AirportJpaRepository airportJpaRepository) {
        this.airportJpaRepository = airportJpaRepository;
    }

    @Override
    public void addAirport(Airport airport) {
        airportJpaRepository.save(airport);
    }

    @Override
    public Airport getAirportByCode(String code) {
        return airportJpaRepository.findById(code).orElse(null);
    }

    @Override
    public List<Airport> getAirportsByCountry(String country) {
        return airportJpaRepository.findByCountry(country);
    }

    @Override
    public List<Airport> getAirportsByCity(String city) {
        return airportJpaRepository.findByCity(city);
    }

    @Override
    public List<Airport> getAirportsByName(String name) {
        return airportJpaRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Airport> getAirportsWithMinRunways(int minRunways) {
        return airportJpaRepository.findAirportsWithMinRunways(minRunways);
    }

    @Override
    public void updateAirport(Airport airport) {
        airportJpaRepository.save(airport);
    }

    @Override
    public void deleteAirportByCode(String code) {
        airportJpaRepository.deleteById(code);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportJpaRepository.findAll();
    }
}
