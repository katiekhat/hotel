package ge.hotel.springbootapp.repositories;

import ge.hotel.springbootapp.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
