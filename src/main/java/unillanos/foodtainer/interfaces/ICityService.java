package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.CityDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

import java.util.List;

public interface ICityService {

    List<CityDTO> findAll() throws FoodTainerException;

}
