package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.UserConstants;
import unillanos.petcity.dto.UserDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ILoginService;
import unillanos.petcity.model.User;
import unillanos.petcity.repository.UserRepository;
import unillanos.petcity.util.Encriptador;
import unillanos.petcity.util.MapperUtil;

@Service
public class LoginService implements ILoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO login(String email, String password) throws PetCityException {
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
            throw new PetCityException(UserConstants.ERROR_LOGGING, exception);
        }
        return response;
    }


}
