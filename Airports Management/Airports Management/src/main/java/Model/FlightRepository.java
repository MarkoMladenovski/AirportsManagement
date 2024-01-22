package Repository;

import Model.Flight;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Flight flight) {
        String sql = "INSERT INTO flights (departure_airport_code, destination_airport_code, departure_time) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, flight.getDepartureAirportCode(), flight.getDestinationAirportCode(), flight.getDepartureTime());
    }

    public Flight findById(Long id) {
        String sql = "SELECT * FROM flights WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Flight.class));
    }

    public List<Flight> findByDepartureAirportCode(String departureAirportCode) {
        String sql = "SELECT * FROM flights WHERE departure_airport_code = ?";
        return jdbcTemplate.query(sql, new Object[]{departureAirportCode}, new BeanPropertyRowMapper<>(Flight.class));
    }

    // Find Flights by Destination Airport Code
    public List<Flight> findByDestinationAirportCode(String destinationAirportCode) {
        String sql = "SELECT * FROM flights WHERE destination_airport_code = ?";
        return jdbcTemplate.query(sql, new Object[]{destinationAirportCode}, new BeanPropertyRowMapper<>(Flight.class));
    }

    // Update Flight
    public void update(Flight flight) {
        String sql = "UPDATE flights SET departure_airport_code = ?, destination_airport_code = ?, departure_time = ? WHERE id = ?";
        jdbcTemplate.update(sql, flight.getDepartureAirportCode(), flight.getDestinationAirportCode(),
                flight.getDepartureTime(), flight.getId());
    }

    // Delete Flight
    public void delete(Long id) {
        String sql = "DELETE FROM flights WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
