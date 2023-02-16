package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.ProductDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

import java.util.List;

public interface IProductService {

    void save(ProductDTO productDTO);

    List<ProductDTO> findByIdRestaurant(int idRestaurant) throws FoodTainerException;

}
