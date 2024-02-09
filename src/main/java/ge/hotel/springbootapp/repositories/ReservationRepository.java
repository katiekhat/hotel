package ge.hotel.springbootapp.repositories;

import ge.hotel.springbootapp.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
}
