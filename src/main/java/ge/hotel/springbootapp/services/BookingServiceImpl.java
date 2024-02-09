package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Rental;
import ge.hotel.springbootapp.entities.Reservation;
import ge.hotel.springbootapp.entities.Room;
import ge.hotel.springbootapp.repositories.RentalRepository;
import ge.hotel.springbootapp.repositories.ReservationRepository;
import ge.hotel.springbootapp.repositories.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final RoomRepository roomRepository;
    private final RentalRepository rentalRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Room reserveRoom(Integer Id, LocalDate startDate, LocalDate endDate) {
        Room room = roomRepository.findById(Id).orElse(null);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }
        if (!isRoomAvailable(room, startDate, endDate)) {
            throw new IllegalStateException("Room is not available for the specified dates");
        }
        Reservation reservation = new Reservation();
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setRoom(room);
        reservationRepository.save(reservation);
//        room.getReservations().add(reservation);
        room.setRoomStatus("reserved");
        return roomRepository.save(room);

    }

    public Room rentRoom(Integer roomId, LocalDate startDate, LocalDate endDate) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }
        if (!isRoomAvailableForRental(room, startDate, endDate)) {
            throw new IllegalStateException("Room is not available for rental for the specified dates");
        }
        Rental rental = new Rental();
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setRoom(room);
        rentalRepository.save(rental);
//        room.getRentals().add(rental);
        room.setRoomStatus("RENTED");
        return roomRepository.save(room);
    }

    @Override
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : room.getReservations()) {
            if (!(endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate()))) {
                return false;
            }
        }
        return true;
    }



    @Override
    public boolean isRoomAvailableForRental(Room room, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : room.getReservations()) {
            if (!(endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate()))) {
                return false;
            }
        }
        for (Rental rental : room.getRentals()) {
            if (!(endDate.isBefore(rental.getStartDate()) || startDate.isAfter(rental.getEndDate()))) {
                return false;
            }
        }
        return true;
    }
}