package unillanos.foodtainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.foodtainer.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
