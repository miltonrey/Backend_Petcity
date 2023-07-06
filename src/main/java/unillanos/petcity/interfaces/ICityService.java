package unillanos.petcity.interfaces;

import unillanos.petcity.dto.CityDTO;
import unillanos.petcity.exceptions.PetCityException;

import java.util.List;

public interface ICityService {

    List<CityDTO> findAll() throws PetCityException;

}
