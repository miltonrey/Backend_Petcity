package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

import java.security.NoSuchAlgorithmException;

public interface IUserService {

    OutboundMessages singUp(UserDTO userDTO) throws FoodTainerException, NoSuchAlgorithmException;

}
