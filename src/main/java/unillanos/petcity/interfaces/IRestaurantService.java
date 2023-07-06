package unillanos.petcity.interfaces;

import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.PetshopDTO;
import unillanos.petcity.exceptions.PetCityException;

public interface IRestaurantService {

    BoundMessages save(PetshopDTO petshopDTO) throws PetCityException;

}
