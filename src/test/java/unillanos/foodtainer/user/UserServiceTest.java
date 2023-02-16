package unillanos.foodtainer.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import unillanos.foodtainer.constants.GlobalConstants;
import unillanos.foodtainer.constants.StatusCodeConstants;
import unillanos.foodtainer.constants.UserConstants;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.model.User;
import unillanos.foodtainer.repository.UserRepository;
import unillanos.foodtainer.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
    void signUpSuccessfully() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(UserConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "Ventilador123", "admin", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpNotValidEmail() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(UserConstants.NOT_VALID_EMAIL, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrrogmail.com", "Ventilador123", "admin", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmailInUse() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(UserConstants.EMAIL_IN_USE, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "Ventilador123", "admin", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.of(new User()));
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmptyEmail() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("", "Ventilador123", "admin", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmptyPassword() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "", "admin", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmptyType() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "Ventilador123", "", "Henry", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmptyName() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "Ventilador123", "admin", "", "Martínez");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }

    @Test
    void signUpEmptyLastname() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        UserDTO userDTO = new UserDTO("Henrro@gmail.com", "Ventilador123", "admin", "Henry", "");
        when(userRepository.findOneByEmailUser(userDTO.getEmail())).thenReturn(Optional.empty());
        OutboundMessages actual = userService.singUp(userDTO);
        assertEquals(expected, actual);
    }
}
