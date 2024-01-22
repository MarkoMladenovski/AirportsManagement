package Controller;

import Model.Airport;
import Service.AirportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebViewController {

    private final AirportService airportService;

    public WebViewController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports-view")
    public String displayAirportsView(Model model) {
        List<Airport> airportList = airportService.getAllAirports();
        model.addAttribute("airportList", airportList);
        return "airports-view";
    }
}
