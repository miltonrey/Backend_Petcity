package unillanos.petcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.CityConstants;
import unillanos.petcity.dto.CityDTO;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ICityService;
import unillanos.petcity.model.City;
import unillanos.petcity.repository.CityRepository;
import unillanos.petcity.util.MapperUtil;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<CityDTO> findAll() throws PetCityException {
        List<CityDTO> cityDTOS;
        try {
            List<City> cities = cityRepository.findAll();
            cityDTOS = cities.stream().map(cityDTO -> new CityDTO(cityDTO.getIdCity(), cityDTO.getNameCity(), MapperUtil.entityToDtoDepartment(cityDTO.getDepartment()))).toList();
        } catch (Exception exception) {
            throw new PetCityException(CityConstants.ERROR_GETTING_ALL, exception);
        }
        return cityDTOS;
    }
}
