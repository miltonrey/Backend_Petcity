package unillanos.petcity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unillanos.petcity.constants.PathConstants;
import unillanos.petcity.dto.CityDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ICityService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_CITY)
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping(PathConstants.FIND_ALL)
    public List<CityDTO> findAll() throws PetCityException {
        return cityService.findAll();
    }

}
