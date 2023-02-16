package unillanos.foodtainer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.foodtainer.constants.PathConstants;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.dto.UserDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.ILoginService;
import unillanos.foodtainer.interfaces.IUserService;

import java.security.NoSuchAlgorithmException;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_USER)
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    ILoginService loginService;

    @PostMapping(PathConstants.SIGN_UP)
    public OutboundMessages signUp(@RequestBody UserDTO userDTO) throws FoodTainerException, NoSuchAlgorithmException {
        return userService.singUp(userDTO);
    }

    @PostMapping(PathConstants.PATH_LOGIN)
    public UserDTO login(@RequestBody UserDTO userDTO) throws FoodTainerException {
        return loginService.login(userDTO.getEmail(), userDTO.getPassword());
    }


}
