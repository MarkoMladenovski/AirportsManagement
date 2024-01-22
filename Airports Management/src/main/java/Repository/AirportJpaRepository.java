package Repository;


import Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportJpaRepository extends JpaRepository<Airport, String> {

    List<Airport> findByCountry(String country);

    List<Airport> findByCity(String city);

    List<Airport> findByNameContainingIgnoreCase(String name);

    List<Airport> findAirportsWithMinRunways(int minRunways);


}
