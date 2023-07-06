package unillanos.petcity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unillanos.petcity.constants.GlobalConstants;
import unillanos.petcity.constants.HeadquarterConstants;
import unillanos.petcity.constants.StatusCodeConstants;
import unillanos.petcity.dto.ConsultaSedeDTO;
import unillanos.petcity.dto.HeadquarterDTO;
import unillanos.petcity.dto.BoundMessages;
import unillanos.petcity.exceptions.PetCityException;
import unillanos.petcity.interfaces.ISedeService;
import unillanos.petcity.model.*;
import unillanos.petcity.repository.*;
import unillanos.petcity.util.MapperUtil;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeadquarterService implements ISedeService {

    private final HeadquarterRepository headquarterRepository;
    private final ContactRepository contactRepository;
    private final PetshopRepository restaurantRepository;
    private final PictureRepository pictureRepository;
    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;

    private final PictureService pictureService;

    private final ProductService productService;

    private final QualificationService qualificationService;


    @Override
    public List<HeadquarterDTO> findAll() throws PetCityException {
        List<HeadquarterDTO> headquarterDTOS;
        try {
            List<Sede> headquarters = headquarterRepository.findAll();
            headquarterDTOS = headquarters.stream().map(headquarter -> {
                try {
                    return new HeadquarterDTO(
                            headquarter.getIdHeadquarter(),
                            headquarter.getNameHeadquarter(),
                            headquarter.getDescriptionHeadquarter(),
                            headquarter.getScheduleHeadquarter(),
                            headquarter.getTypeHeadquarter(),
                            pictureService.findById(headquarter.getPicture().getIdPicture()),
                            null,
                            null,
                            null,
                            null);
                } catch (PetCityException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
        } catch (Exception exception) {
            throw new PetCityException(HeadquarterConstants.ERROR_GETTING_ALL, exception);
        }
        return headquarterDTOS;
    }

    @Override
    public BoundMessages save(HeadquarterDTO headquarterDTO) throws PetCityException {
        Sede headquarter = new Sede();
        try {
            if (!headquarterDTO.getName().isBlank() && !headquarterDTO.getDescription().isBlank() && !headquarterDTO.getSchedule().isBlank() && !headquarterDTO.getType().isBlank()) {
                headquarter.setNameHeadquarter(headquarterDTO.getName());
                headquarter.setDescriptionHeadquarter(headquarterDTO.getDescription());
                headquarter.setScheduleHeadquarter(headquarterDTO.getSchedule());
                headquarter.setTypeHeadquarter(headquarterDTO.getType());
                Optional<Image> picture = pictureRepository.findById(headquarterDTO.getPicture().getId());
                if (picture.isPresent()) {
                    headquarter.setPicture(picture.get());
                } else {
                    return new BoundMessages(HeadquarterConstants.PICTURE_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<City> city = cityRepository.findById(headquarterDTO.getCity().getId());
                if (city.isPresent()) {
                    headquarter.setCity(city.get());
                } else {
                    return new BoundMessages(HeadquarterConstants.CITY_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Contact> contact = contactRepository.findById(headquarterDTO.getContact().getId());
                if (contact.isPresent()) {
                    headquarter.setContact(contact.get());
                } else {
                    return new BoundMessages(HeadquarterConstants.CONTACT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Petshop> restaurant = restaurantRepository.findById(headquarterDTO.getPetshop().getId());
                if (restaurant.isPresent()) {
                    headquarter.setRestaurant(restaurant.get());
                } else {
                    return new BoundMessages(HeadquarterConstants.RESTAURANT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Location> location = locationRepository.findById(headquarterDTO.getLocation().getId());
                if (location.isPresent()) {
                    headquarter.setLocation(location.get());
                } else {
                    return new BoundMessages(HeadquarterConstants.LOCATION_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                headquarterRepository.save(headquarter);
            } else {
                return new BoundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new PetCityException(HeadquarterConstants.ERROR_SAVING, exception);
        }
        return new BoundMessages(HeadquarterConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

    @Override
    public ConsultaSedeDTO findById(int id) throws PetCityException {
        ConsultaSedeDTO response = new ConsultaSedeDTO();
        Sede headquarter = headquarterRepository.getReferenceById(id);
        response.setHeadquarter(MapperUtil.entityToDtoHeadquarter(headquarter));
        response.setProducts(productService.findByIdRestaurant(headquarter.getRestaurant().getIdRestaurant()));
        response.setQualifications(qualificationService.findByIdRestaurant(headquarter.getRestaurant().getIdRestaurant()));
        return response;
    }


}
