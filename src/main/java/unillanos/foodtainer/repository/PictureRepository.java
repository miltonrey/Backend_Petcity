package unillanos.foodtainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.foodtainer.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
