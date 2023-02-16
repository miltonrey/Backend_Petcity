package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

public interface ILoginService {

     UserDTO login(String email, String password) throws FoodTainerException;
}
