package ge.hotel.springbootapp.controllers;

import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.entities.Rental;
import ge.hotel.springbootapp.entities.Reservation;
import ge.hotel.springbootapp.entities.Room;
import ge.hotel.springbootapp.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/{roomId}/reserve")
    public Room reserveRoom(@PathVariable Integer roomId, @RequestBody Reservation reservation)  {
        LocalDate startDate = reservation.getStartDate();
        LocalDate endDate = reservation.getEndDate();
        return bookingService.rentRoom(roomId, startDate, endDate);
    }



    @PostMapping("/{roomId}/rent")
    public Room rentRoom(@PathVariable Integer roomId, @RequestBody Rental rental) {
        LocalDate startDate = rental.getStartDate();
        LocalDate endDate = rental.getEndDate();
        return bookingService.rentRoom(roomId, startDate, endDate);
    }
}
