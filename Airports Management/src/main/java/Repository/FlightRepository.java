package Repository;

import Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepository {


    private final FlightJpaRepository flightJpaRepository;

    @Autowired
    public FlightRepository(FlightJpaRepository flightJpaRepository) {
        this.flightJpaRepository = flightJpaRepository;
    }

    public void save(Flight flight) {
        flightJpaRepository.save(flight);
    }

    public Flight findById(Long id) {
        return flightJpaRepository.findById(id).orElse(null);
    }

    public List<Flight> findByDepartureAirportCode(String departureAirportCode) {
        return flightJpaRepository.findByDepartureAirportCode(departureAirportCode);
    }

    public List<Flight> findByDestinationAirportCode(String destinationAirportCode) {
        return flightJpaRepository.findByDestinationAirportCode(destinationAirportCode);
    }

    public void update(Flight flight) {
        flightJpaRepository.save(flight);
    }

    public void delete(Long id) {
        flightJpaRepository.deleteById(id);
    }

    public List<Flight> findAll() {
        return flightJpaRepository.findAll();
    }

    public void deleteById(Long id) {
        flightJpaRepository.deleteById(id);
    }
}
