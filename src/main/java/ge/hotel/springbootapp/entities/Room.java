package ge.hotel.springbootapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "floor")
    private int floor;
    @Column(name = "category")
    private String category;
    @Column(name = "total_room")
    private int totalRooms;
    @Column(name = "num_beds")
    private int beds;
    @Column(name = "price")
    private double price;
    @Column(name = "room_status")
    private String roomStatus;
    // "available", "reserved", "rented"

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Rental> rentals;
}
