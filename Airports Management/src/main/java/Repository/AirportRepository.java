package Repository;

import Model.Airport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportRepository {

    private final JdbcTemplate jdbcTemplate;

    public AirportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Airport airport) {
        String sql = "INSERT INTO airports (code, name, country, city, timeZone, numberOfRunways) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, airport.getCode(), airport.getName(), airport.getCountry(),
                airport.getCity(), airport.getTimeZone(), airport.getNumberOfRunways());
    }

    public Airport findByCode(String code) {
        String sql = "SELECT * FROM airports WHERE code = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{code}, new BeanPropertyRowMapper<>(Airport.class));
    }

    public List<Airport> findByCountry(String country) {
        String sql = "SELECT * FROM airports WHERE country = ?";
        return jdbcTemplate.query(sql, new Object[]{country}, new BeanPropertyRowMapper<>(Airport.class));
    }

    public List<Airport> findByCity(String city) {
        String sql = "SELECT * FROM airports WHERE city = ?";
        return jdbcTemplate.query(sql, new Object[]{city}, new BeanPropertyRowMapper<>(Airport.class));
    }

    public List<Airport> findByNameContainingIgnoreCase(String name) {
        String sql = "SELECT * FROM airports WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, new BeanPropertyRowMapper<>(Airport.class));
    }


    public List<Airport> findAirportsWithMinRunways(int minRunways) {
        String sql = "SELECT * FROM airports WHERE numberOfRunways > ?";
        return jdbcTemplate.query(sql, new Object[]{minRunways}, new BeanPropertyRowMapper<>(Airport.class));
    }

    public void update(Airport airport) {
        String sql = "UPDATE airports SET name = ?, country = ?, city = ?, timeZone = ?, numberOfRunways = ? WHERE code = ?";
        jdbcTemplate.update(sql, airport.getName(), airport.getCountry(), airport.getCity(),
                airport.getTimeZone(), airport.getNumberOfRunways(), airport.getCode());
    }


    public void delete(String code) {
        String sql = "DELETE FROM airports WHERE code = ?";
        jdbcTemplate.update(sql, code);
    }

    public List<Airport> findAll() {
        return null;
    }

    public void deleteByCode(String code) {
    }
}

