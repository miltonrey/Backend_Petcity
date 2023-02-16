package unillanos.foodtainer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.foodtainer.constants.PathConstants;
import unillanos.foodtainer.dto.ConsultHeadquarterResponseDTO;
import unillanos.foodtainer.dto.HeadquarterDTO;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IHeadquarterService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_HEADQUARTER)
public class HeadquarterController {

    @Autowired
    IHeadquarterService headquarterService;

    @GetMapping(PathConstants.FIND_ALL)
    public List<HeadquarterDTO> findAll() throws FoodTainerException {
        return headquarterService.findAll();
    }

    @PostMapping(PathConstants.SAVE)
    public OutboundMessages save(@RequestBody HeadquarterDTO headquarterDTO) throws FoodTainerException {
        return headquarterService.save(headquarterDTO);
    }

    @GetMapping(PathConstants.FIND_BY_ID)
    public ConsultHeadquarterResponseDTO findById(@PathVariable int id) throws FoodTainerException {
        return headquarterService.findById(id);
    }

}
