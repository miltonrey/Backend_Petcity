package unillanos.petcity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.petcity.constants.PathConstants;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.dto.UserDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ILoginService;
import unillanos.petcity.interfaces.IUserService;

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
    public BoundMessages signUp(@RequestBody UserDTO userDTO) throws PetCityException, NoSuchAlgorithmException {
        return userService.singUp(userDTO);
    }

    @PostMapping(PathConstants.PATH_LOGIN)
    public UserDTO login(@RequestBody UserDTO userDTO) throws PetCityException {
        return loginService.login(userDTO.getEmail(), userDTO.getPassword());
    }


}
