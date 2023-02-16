package unillanos.foodtainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.foodtainer.model.Headquarter;

@Repository
public interface HeadquarterRepository extends JpaRepository<Headquarter, Integer> {
}
