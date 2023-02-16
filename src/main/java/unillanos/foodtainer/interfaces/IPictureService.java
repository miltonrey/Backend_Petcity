package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.PictureDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;

public interface IPictureService {

    PictureDTO findById(int id) throws FoodTainerException;

    //OutboundMessages uploadImage(PictureDTO pictureDTO) throws FoodTainerException;

}
