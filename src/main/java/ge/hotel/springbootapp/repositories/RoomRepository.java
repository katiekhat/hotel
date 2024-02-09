package ge.hotel.springbootapp.repositories;

import ge.hotel.springbootapp.entities.Hotel;
import ge.hotel.springbootapp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByHotelId(Integer hotelId);
}
