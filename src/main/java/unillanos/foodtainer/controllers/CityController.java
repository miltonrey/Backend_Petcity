package unillanos.foodtainer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unillanos.foodtainer.constants.PathConstants;
import unillanos.foodtainer.dto.CityDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.ICityService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_CITY)
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping(PathConstants.FIND_ALL)
    public List<CityDTO> findAll() throws FoodTainerException {
        return cityService.findAll();
    }

}
