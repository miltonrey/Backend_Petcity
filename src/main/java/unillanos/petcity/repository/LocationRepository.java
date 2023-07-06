package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
