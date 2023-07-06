package unillanos.petcity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.petcity.constants.PathConstants;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.PetshopDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IRestaurantService;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_PETSHOP)
public class PetshopController {

    @Autowired
    IRestaurantService petshopService;

    @PostMapping(PathConstants.SAVE)
    public BoundMessages save(@RequestBody PetshopDTO petshopDTO) throws PetCityException {
        return petshopService.save(petshopDTO);
    }

}
