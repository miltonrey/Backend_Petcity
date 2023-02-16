package unillanos.foodtainer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.foodtainer.constants.PathConstants;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.RestaurantDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IRestaurantService;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_RESTAURANT)
public class RestaurantController {

    @Autowired
    IRestaurantService restaurantService;

    @PostMapping(PathConstants.SAVE)
    public OutboundMessages save(@RequestBody RestaurantDTO restaurantDTO) throws FoodTainerException {
        return restaurantService.save(restaurantDTO);
    }

}
