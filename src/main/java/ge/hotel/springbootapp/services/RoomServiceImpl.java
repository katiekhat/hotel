package ge.hotel.springbootapp.services;

import ge.hotel.springbootapp.entities.Room;
import ge.hotel.springbootapp.repositories.RentalRepository;
import ge.hotel.springbootapp.repositories.ReservationRepository;
import ge.hotel.springbootapp.repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
    @Override
    public Room updateRoom(Room room) {
      Room  existingRoom = roomRepository.findById(room.getId())
              .orElseThrow(()-> new EntityNotFoundException("no such room"));
      existingRoom.setRoomNumber(room.getRoomNumber());
      existingRoom.setFloor(room.getFloor());
      existingRoom.setTotalRooms(room.getTotalRooms());
      existingRoom.setCategory(room.getCategory());
      existingRoom.setBeds(room.getBeds());
      existingRoom.setPrice(room.getPrice());
      existingRoom.setRoomStatus(room.getRoomStatus());
      return roomRepository.save(existingRoom);
    }

    @Override
    public List<Room> getAllRoomsByHotelId(Integer hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }


}
