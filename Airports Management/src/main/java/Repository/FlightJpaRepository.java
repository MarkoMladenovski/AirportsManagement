package Repository;

import Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightJpaRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureAirportCode(String departureAirportCode);

    List<Flight> findByDestinationAirportCode(String destinationAirportCode);

    List<Flight> findByDepartureTimeBeforeAndDestinationTimeAfter(String departureTime, String destinationTime);

    List<Flight> findByAirline(String airline);

    List<Flight> findByAirlineAndDepartureAirportCode(String airline, String departureAirportCode);

    List<Flight> findByAirlineAndDestinationAirportCode(String airline, String destinationAirportCode);
}
