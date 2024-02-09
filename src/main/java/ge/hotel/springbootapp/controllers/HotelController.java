package ge.hotel.springbootapp.controllers;

import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.entities.Room;
import ge.hotel.springbootapp.services.HotelService;
import ge.hotel.springbootapp.services.RoomService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;
    private final RoomService roomService;


    @GetMapping("")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    @PutMapping("/edit/{Id}")
    public ResponseEntity<Hotel> editHotelInfo(
            @PathVariable Integer Id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String address,
            @RequestParam boolean parking,
            @RequestParam boolean wifi) {
        Hotel editedHotel = hotelService.editHotelInfo(Id, name, description, address, parking, wifi);
        return new ResponseEntity<>(editedHotel, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel addedHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(addedHotel, HttpStatus.CREATED);
    }
    @GetMapping("/{hotelId}/rooms")
    public ResponseEntity<List<Room>> getAllRoomsByHotelId(@PathVariable Integer hotelId) {
        List<Room> rooms = roomService.getAllRoomsByHotelId(hotelId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}