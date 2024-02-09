package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Room;

import java.time.LocalDate;

public interface BookingService {
    Room reserveRoom(Integer Id, LocalDate startDate, LocalDate endDate);
    Room rentRoom(Integer roomId, LocalDate startDate, LocalDate endDate);
    boolean isRoomAvailableForRental(Room room, LocalDate startDate, LocalDate endDate);
    boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate);
}
