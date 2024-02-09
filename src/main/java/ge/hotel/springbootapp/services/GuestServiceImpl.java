package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Guest;
import ge.hotel.springbootapp.repositories.GuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    @Override
    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
