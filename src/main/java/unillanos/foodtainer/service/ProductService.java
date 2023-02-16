package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.ProductConstants;
import unillanos.foodtainer.dto.ProductDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IProductService;
import unillanos.foodtainer.model.Product;
import unillanos.foodtainer.repository.ProductRepository;
import unillanos.foodtainer.util.MapperUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(ProductDTO productDTO) {

    }

    @Override
    public List<ProductDTO> findByIdRestaurant(int idRestaurant) throws FoodTainerException {
        List<ProductDTO> response;
        try {
            List<Product> products = productRepository.findProductByRestaurant(idRestaurant);
            response = MapperUtil.entityToDtoProductList(products);
        } catch (Exception exception) {
            throw new FoodTainerException(ProductConstants.ERROR_GETTING_BY_RESTAURANT, exception);
        }
        return response;
    }


}
