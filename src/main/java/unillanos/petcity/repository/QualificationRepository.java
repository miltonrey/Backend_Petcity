package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import unillanos.petcity.model.Qualification;

import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {

    @Query("SELECT q FROM Qualification q WHERE q.restaurant.idRestaurant = ?1")
    List<Qualification> findProductByRestaurant(int idRestaurant);

}
