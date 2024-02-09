package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    Room addRoom(Room  room);
    Room updateRoom(Room room);
    List<Room> getAllRoomsByHotelId(Integer hotelId);
}
