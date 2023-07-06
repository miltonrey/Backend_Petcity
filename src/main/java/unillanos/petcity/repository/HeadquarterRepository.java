package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.Sede;

@Repository
public interface HeadquarterRepository extends JpaRepository<Sede, Integer> {

}
