package unillanos.petcity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unillanos.petcity.constants.PathConstants;
import unillanos.petcity.dto.ConsultaSedeDTO;
import unillanos.petcity.dto.HeadquarterDTO;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ISedeService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(PathConstants.PATH_SEDE)
public class SedeController {

    @Autowired
    ISedeService headquarterService;

    @GetMapping(PathConstants.FIND_ALL)
    public List<HeadquarterDTO> findAll() throws PetCityException {
        return headquarterService.findAll();
    }

    @PostMapping(PathConstants.SAVE)
    public BoundMessages save(@RequestBody HeadquarterDTO headquarterDTO) throws PetCityException {
        return headquarterService.save(headquarterDTO);
    }

    @GetMapping(PathConstants.FIND_BY_ID)
    public ConsultaSedeDTO findById(@PathVariable int id) throws PetCityException {
        return headquarterService.findById(id);
    }

}
