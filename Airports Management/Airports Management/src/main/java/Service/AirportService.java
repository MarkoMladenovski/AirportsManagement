package Service;

import Model.Airport;

import java.util.List;

public interface AirportService {

    void addAirport(Airport airport);

    Airport getAirportByCode(String code);

    List<Airport> getAirportsByCountry(String country);

    List<Airport> getAirportsByCity(String city);

    List<Airport> getAirportsByName(String name);

    List<Airport> getAirportsWithMinRunways(int minRunways);

    void updateAirport(Airport airport);

    void deleteAirportByCode(String code);

    List<Airport> getAllAirports();
}
