package unillanos.foodtainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.CityConstants;
import unillanos.foodtainer.dto.CityDTO;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.ICityService;
import unillanos.foodtainer.model.City;
import unillanos.foodtainer.repository.CityRepository;
import unillanos.foodtainer.util.MapperUtil;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<CityDTO> findAll() throws FoodTainerException {
        List<CityDTO> cityDTOS;
        try {
            List<City> cities = cityRepository.findAll();
            cityDTOS = cities.stream().map(cityDTO -> new CityDTO(cityDTO.getIdCity(), cityDTO.getNameCity(), MapperUtil.entityToDtoDepartment(cityDTO.getDepartment()))).toList();
        } catch (Exception exception) {
            throw new FoodTainerException(CityConstants.ERROR_GETTING_ALL, exception);
        }
        return cityDTOS;
    }
}
