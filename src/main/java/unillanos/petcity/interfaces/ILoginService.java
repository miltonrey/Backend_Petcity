package unillanos.petcity.interfaces;

import unillanos.petcity.dto.UserDTO;
import unillanos.petcity.exceptions.PetCityException;

public interface ILoginService {

     UserDTO login(String email, String password) throws PetCityException;
}
