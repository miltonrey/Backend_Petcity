package unillanos.petcity.interfaces;

import unillanos.petcity.dto.ProductDTO;
import unillanos.petcity.exceptions.PetCityException;

import java.util.List;

public interface IProductService {

    void save(ProductDTO productDTO);

    List<ProductDTO> findByIdRestaurant(int idRestaurant) throws PetCityException;

}
