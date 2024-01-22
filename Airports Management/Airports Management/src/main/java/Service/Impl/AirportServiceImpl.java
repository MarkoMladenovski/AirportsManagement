//package Service.Impl;
//
//
//import Entity.Airport;
//import Model.AirportRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AirportServiceImpl implements AirportService {
//
//    private final AirportRepository airportRepository;
//
//    @Autowired
//    public AirportServiceImpl(AirportRepository airportRepository) {
//        this.airportRepository = airportRepository;
//    }
//
//    @Override
//    public List<Airport> getAllAirports() {
//        return airportRepository.findAll();
//    }
//
//    @Override
//    public Optional<Airport> getAirportByCode(String code) {
//        return airportRepository.findByCode(code);
//    }
//
//    @Override
//    public List<Airport> getAirportsByCountry(String country) {
//        return airportRepository.findByCountry(country);
//    }
//
//    @Override
//    public void addAirport(Airport airport) {
//        airportRepository.save(airport);
//    }
//
//    @Override
//    public void updateAirport(Airport airport) {
//        // Assuming airportRepository.save() also updates existing records
//        airportRepository.save(airport);
//    }
//
//    @Override
//    public void deleteAirportByCode(String code) {
//        airportRepository.deleteByCode(code);
//    }
//
//    // You can add more methods based on your requirements
//
//}
//
