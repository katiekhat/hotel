package ge.hotel.springbootapp.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Integer id;

    @Column(name = "hotel_name")
    private String name;

    @Column(name = "hotel_description")
    private String description;

    @Column(name = "hotel_address")
    private String address;

    @Column(name = "hotel_parking")
    private boolean parking;

    @Column(name = "hotel_wifi")
    private boolean wifi;

}
