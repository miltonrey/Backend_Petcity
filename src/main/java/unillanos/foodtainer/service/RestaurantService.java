package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.GlobalConstants;
import unillanos.foodtainer.constants.RestaurantConstants;
import unillanos.foodtainer.constants.StatusCodeConstants;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.RestaurantDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IRestaurantService;
import unillanos.foodtainer.model.Restaurant;
import unillanos.foodtainer.model.User;
import unillanos.foodtainer.repository.RestaurantRepository;
import unillanos.foodtainer.repository.UserRepository;

import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public OutboundMessages save(RestaurantDTO restaurantDTO) throws FoodTainerException {
        Restaurant restaurant = new Restaurant();
        Optional<User> user = userRepository.findOneByEmailUser(restaurantDTO.getEmail());
        try {
            if (!restaurantDTO.getName().isBlank() && !restaurantDTO.getEmail().isBlank()) {
                if (user.isPresent()) {
                    restaurant.setEmailRestaurant(user.get());
                    restaurant.setNameRestaurant(restaurantDTO.getName());
                    restaurantRepository.save(restaurant);
                } else {
                    return new OutboundMessages(RestaurantConstants.EMAIL_IN_USE, StatusCodeConstants.BAD_REQUEST);
                }
            } else {
                return new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new FoodTainerException(RestaurantConstants.ERROR_SAVING, exception);
        }
        return new OutboundMessages(RestaurantConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

}
