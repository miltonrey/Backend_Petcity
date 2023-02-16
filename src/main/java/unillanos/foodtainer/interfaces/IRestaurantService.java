package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.RestaurantDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

public interface IRestaurantService {

    OutboundMessages save(RestaurantDTO restaurantDTO) throws FoodTainerException;

}
