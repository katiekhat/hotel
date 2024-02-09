package ge.hotel.springbootapp.controllers;

import ge.hotel.springbootapp.entities.Guest;
import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.services.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    @PostMapping("/add")
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        Guest addedGuest = guestService.addGuest(guest);
        return new ResponseEntity<>(addedGuest, HttpStatus.CREATED);
    }


}
