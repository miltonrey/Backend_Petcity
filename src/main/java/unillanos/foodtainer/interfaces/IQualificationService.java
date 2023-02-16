package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.ProductDTO;
import unillanos.foodtainer.dto.QualificationDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

import java.util.List;

public interface IQualificationService {

    List<QualificationDTO> findByIdRestaurant(int idRestaurant) throws FoodTainerException;

}
