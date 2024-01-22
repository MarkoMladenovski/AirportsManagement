package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                      // Unique identifier for the flight

    private String departureAirportCode;  // Code of the departure airport
    private String destinationAirportCode;// Code of the destination airport
    private String departureTime;         // Departure time in a suitable format (e.g., ISO 8601)

    // Constructors
    public Flight() {
        // Default constructor required by JPA
    }

    public Flight(String departureAirportCode, String destinationAirportCode, String departureTime) {
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureTime = departureTime;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    // hashCode and equals methods (based on the departureAirportCode and destinationAirportCode)
    @Override
    public int hashCode() {
        int result = departureAirportCode != null ? departureAirportCode.hashCode() : 0;
        result = 31 * result + (destinationAirportCode != null ? destinationAirportCode.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Flight flight = (Flight) obj;
        return departureAirportCode != null ? departureAirportCode.equals(flight.departureAirportCode) : flight.departureAirportCode == null &&
                destinationAirportCode != null ? destinationAirportCode.equals(flight.destinationAirportCode) : flight.destinationAirportCode == null;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
