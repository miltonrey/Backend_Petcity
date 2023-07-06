package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.Image;

@Repository
public interface PictureRepository extends JpaRepository<Image, Integer> {
}
