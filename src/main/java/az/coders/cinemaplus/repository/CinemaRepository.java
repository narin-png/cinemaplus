package az.coders.cinemaplus.repository;

import az.coders.cinemaplus.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
