package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
