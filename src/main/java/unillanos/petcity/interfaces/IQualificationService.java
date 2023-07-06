package unillanos.petcity.interfaces;

import unillanos.petcity.dto.QualificationDTO;
import unillanos.petcity.exceptions.PetCityException;

import java.util.List;

public interface IQualificationService {

    List<QualificationDTO> findByIdRestaurant(int idRestaurant) throws PetCityException;

}
