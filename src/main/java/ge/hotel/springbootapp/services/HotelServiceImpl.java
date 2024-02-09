package ge.hotel.springbootapp.services;
import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.repositories.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel editHotelInfo(Integer Id, String name, String description, String address, boolean parking, boolean wifi) {
        Hotel existingHotel =hotelRepository.findById(Id).
                orElseThrow(()-> new EntityNotFoundException("Hotel not found"));
        existingHotel.setName(name);
        existingHotel.setDescription(description);
        existingHotel.setAddress(address);
        existingHotel.setParking(parking);
        existingHotel.setWifi(wifi);
        return hotelRepository.save(existingHotel);

    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
