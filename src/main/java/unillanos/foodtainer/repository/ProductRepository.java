package unillanos.foodtainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unillanos.foodtainer.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.restaurant.idRestaurant = ?1")
    List<Product> findProductByRestaurant(int idRestaurant);

}
