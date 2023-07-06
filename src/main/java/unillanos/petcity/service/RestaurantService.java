package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.GlobalConstants;
import unillanos.petcity.constants.RestaurantConstants;
import unillanos.petcity.constants.StatusCodeConstants;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.PetshopDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IRestaurantService;
import unillanos.petcity.model.Petshop;
import unillanos.petcity.model.User;
import unillanos.petcity.repository.PetshopRepository;
import unillanos.petcity.repository.UserRepository;

import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    PetshopRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public BoundMessages save(PetshopDTO petshopDTO) throws PetCityException {
        Petshop restaurant = new Petshop();
        Optional<User> user = userRepository.findOneByEmailUser(petshopDTO.getEmail());
        try {
            if (!petshopDTO.getName().isBlank() && !petshopDTO.getEmail().isBlank()) {
                if (user.isPresent()) {
                    restaurant.setEmailRestaurant(user.get());
                    restaurant.setNameRestaurant(petshopDTO.getName());
                    restaurantRepository.save(restaurant);
                } else {
                    return new BoundMessages(RestaurantConstants.EMAIL_IN_USE, StatusCodeConstants.BAD_REQUEST);
                }
            } else {
                return new BoundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new PetCityException(RestaurantConstants.ERROR_SAVING, exception);
        }
        return new BoundMessages(RestaurantConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

}
