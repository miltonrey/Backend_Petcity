package unillanos.foodtainer.interfaces;

import unillanos.foodtainer.dto.ConsultHeadquarterResponseDTO;
import unillanos.foodtainer.dto.HeadquarterDTO;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.exceptions.FoodTainerException;

import java.util.List;

public interface IHeadquarterService {

    List<HeadquarterDTO> findAll() throws FoodTainerException;

    OutboundMessages save(HeadquarterDTO headquarterDTO) throws FoodTainerException;

    ConsultHeadquarterResponseDTO findById(int id) throws FoodTainerException;

}
