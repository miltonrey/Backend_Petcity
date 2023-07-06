package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.GlobalConstants;
import unillanos.petcity.constants.StatusCodeConstants;
import unillanos.petcity.constants.UserConstants;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.UserDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.IUserService;
import unillanos.petcity.model.User;
import unillanos.petcity.repository.UserRepository;
import unillanos.petcity.util.Encriptador;
import unillanos.petcity.util.ValidadorCampos;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public BoundMessages singUp(UserDTO userDTO) throws PetCityException {
        User user = new User();
        try {
            if (!userDTO.getEmail().isBlank() && !userDTO.getPassword().isBlank() && !userDTO.getTypeUser().isBlank() && !userDTO.getName().isBlank() && !userDTO.getLastname().isBlank()) {
                if (ValidadorCampos.validateEmailFormat(userDTO.getEmail())) {
                    if (userRepository.findOneByEmailUser(userDTO.getEmail()).isEmpty()) {
                        user.setEmailUser(userDTO.getEmail());
                        user.setPasswordUser(new Encriptador().encriptar(userDTO.getPassword()));
                        user.setTypeUser(userDTO.getTypeUser());
                        user.setNameUser(userDTO.getName());
                        user.setLastName(userDTO.getLastname());
                        System.out.println("Entro");
                        userRepository.save(user);
                    } else {
                        return new BoundMessages(UserConstants.EMAIL_IN_USE, StatusCodeConstants.BAD_REQUEST);
                    }
                } else {
                    return new BoundMessages(UserConstants.NOT_VALID_EMAIL, StatusCodeConstants.BAD_REQUEST);
                }
            } else {
                return new BoundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new PetCityException(UserConstants.ERROR_SAVING, exception);
        }
        return new BoundMessages(UserConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

}
