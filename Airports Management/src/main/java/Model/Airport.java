package Model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;             // Unique identifier for the airport

    private String code;         // Airport code (e.g., IATA code)
    private String name;         // Airport name
    private String country;      // Country where the airport is located
    private String city;         // City where the airport is located
    private String timeZone;     // Time zone of the airport
    private int numberOfRunways; // Number of runways at the airport

    // Constructors
    public Airport() {
    }

    public Airport(String code, String name, String country, String city, String timeZone, int numberOfRunways) {
        this.code = code;
        this.name = name;
        this.country = country;
        this.city = city;
        this.timeZone = timeZone;
        this.numberOfRunways = numberOfRunways;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public int getNumberOfRunways() {
        return numberOfRunways;
    }

    public void setNumberOfRunways(int numberOfRunways) {
        this.numberOfRunways = numberOfRunways;
    }

    // hashCode and equals methods (based on the 'code' property)
    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Airport airport = (Airport) obj;
        return code != null ? code.equals(airport.code) : airport.code == null;
    }

    // toString method for easy debugging
    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", numberOfRunways=" + numberOfRunways +
                '}';
    }
}
