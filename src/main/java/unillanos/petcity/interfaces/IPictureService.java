package unillanos.petcity.interfaces;

import unillanos.petcity.dto.PictureDTO;
import unillanos.petcity.exceptions.PetCityException;

public interface IPictureService {

    PictureDTO findById(int id) throws PetCityException;

    //OutboundMessages uploadImage(PictureDTO pictureDTO) throws FoodTainerException;

}
