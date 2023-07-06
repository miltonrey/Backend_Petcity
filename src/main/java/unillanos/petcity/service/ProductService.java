package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.ProductConstants;
import unillanos.petcity.dto.ProductDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IProductService;
import unillanos.petcity.model.Product;
import unillanos.petcity.repository.ProductRepository;
import unillanos.petcity.util.MapperUtil;

import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(ProductDTO productDTO) {

    }

    @Override
    public List<ProductDTO> findByIdRestaurant(int idRestaurant) throws PetCityException {
        List<ProductDTO> response;
        try {
            List<Product> products = productRepository.findProductByRestaurant(idRestaurant);
            response = MapperUtil.entityToDtoProductList(products);
        } catch (Exception exception) {
            throw new PetCityException(ProductConstants.ERROR_GETTING_BY_RESTAURANT, exception);
        }
        return response;
    }


}
