package unillanos.petcity.interfaces;

import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.UserDTO;
import unillanos.petcity.exceptions.PetCityException;

import java.security.NoSuchAlgorithmException;

public interface IUserService {

    BoundMessages singUp(UserDTO userDTO) throws PetCityException, NoSuchAlgorithmException;

}
