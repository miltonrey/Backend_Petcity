package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.Petshop;

@Repository
public interface PetshopRepository extends JpaRepository<Petshop, Integer> {

    @Query("SELECT r FROM Petshop r WHERE r.emailRestaurant = ?1")
    Petshop findByEmailRestaurant(String email);

}
