package unillanos.petcity.interfaces;

import unillanos.petcity.dto.ConsultaSedeDTO;
import unillanos.petcity.dto.HeadquarterDTO;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.exceptions.PetCityException;

import java.util.List;

public interface ISedeService {

    List<HeadquarterDTO> findAll() throws PetCityException;

    BoundMessages save(HeadquarterDTO headquarterDTO) throws PetCityException;

    ConsultaSedeDTO findById(int id) throws PetCityException;

}
