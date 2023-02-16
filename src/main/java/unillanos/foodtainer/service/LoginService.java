package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.UserConstants;
import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.ILoginService;
import unillanos.foodtainer.model.User;
import unillanos.foodtainer.repository.UserRepository;
import unillanos.foodtainer.util.Encriptador;
import unillanos.foodtainer.util.MapperUtil;

@Service
public class LoginService implements ILoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO login(String email, String password) throws FoodTainerException {
        UserDTO response = new UserDTO();
        try {
            String encryptedPassword = new Encriptador().encriptar(password);
            User u = userRepository.findByEmailUserAndPasswordUser(email, encryptedPassword);
            if (u != null) {
                response = MapperUtil.entityToDtoUser(u);
            } else {
                return response;
            }
        } catch (Exception exception) {
            throw new FoodTainerException(UserConstants.ERROR_LOGGING, exception);
        }
        return response;
    }


}
