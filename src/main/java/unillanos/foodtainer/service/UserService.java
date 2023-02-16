package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.GlobalConstants;
import unillanos.foodtainer.constants.StatusCodeConstants;
import unillanos.foodtainer.constants.UserConstants;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IUserService;
import unillanos.foodtainer.model.User;
import unillanos.foodtainer.repository.UserRepository;
import unillanos.foodtainer.util.Encriptador;
import unillanos.foodtainer.util.ValidateField;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public OutboundMessages singUp(UserDTO userDTO) throws FoodTainerException {
        User user = new User();
        try {
            if (!userDTO.getEmail().isBlank() && !userDTO.getPassword().isBlank() && !userDTO.getTypeUser().isBlank() && !userDTO.getName().isBlank() && !userDTO.getLastname().isBlank()) {
                if (ValidateField.validateEmailFormat(userDTO.getEmail())) {
                    if (userRepository.findOneByEmailUser(userDTO.getEmail()).isEmpty()) {
                        user.setEmailUser(userDTO.getEmail());
                        user.setPasswordUser(new Encriptador().encriptar(userDTO.getPassword()));
                        user.setTypeUser(userDTO.getTypeUser());
                        user.setNameUser(userDTO.getName());
                        user.setLastName(userDTO.getLastname());
                        userRepository.save(user);
                    } else {
                        return new OutboundMessages(UserConstants.EMAIL_IN_USE, StatusCodeConstants.BAD_REQUEST);
                    }
                } else {
                    return new OutboundMessages(UserConstants.NOT_VALID_EMAIL, StatusCodeConstants.BAD_REQUEST);
                }
            } else {
                return new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new FoodTainerException(UserConstants.ERROR_SAVING, exception);
        }
        return new OutboundMessages(UserConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

}
