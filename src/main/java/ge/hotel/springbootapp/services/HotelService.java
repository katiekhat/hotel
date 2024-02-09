package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.entities.Room;

import java.util.List;

public interface HotelService {
 Hotel editHotelInfo(Integer Id, String name, String description, String address, boolean parking, boolean wifi);
 Hotel addHotel(Hotel hotel);
 List<Hotel> getAllHotels();
}
