package unillanos.foodtainer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unillanos.foodtainer.constants.GlobalConstants;
import unillanos.foodtainer.constants.HeadquarterConstants;
import unillanos.foodtainer.constants.StatusCodeConstants;
import unillanos.foodtainer.dto.ConsultHeadquarterResponseDTO;
import unillanos.foodtainer.dto.HeadquarterDTO;
import unillanos.foodtainer.dto.OutboundMessages;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.interfaces.IHeadquarterService;
import unillanos.foodtainer.model.*;
import unillanos.foodtainer.repository.*;
import unillanos.foodtainer.util.MapperUtil;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeadquarterService implements IHeadquarterService {

    private final HeadquarterRepository headquarterRepository;
    private final ContactRepository contactRepository;
    private final RestaurantRepository restaurantRepository;
    private final PictureRepository pictureRepository;
    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;

    private final PictureService pictureService;

    private final ProductService productService;

    private final QualificationService qualificationService;


    @Override
    public List<HeadquarterDTO> findAll() throws FoodTainerException {
        List<HeadquarterDTO> headquarterDTOS;
        try {
            List<Headquarter> headquarters = headquarterRepository.findAll();
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
                } catch (FoodTainerException e) {
                    throw new RuntimeException(e);
                }
            }).toList();
        } catch (Exception exception) {
            throw new FoodTainerException(HeadquarterConstants.ERROR_GETTING_ALL, exception);
        }
        return headquarterDTOS;
    }

    @Override
    public OutboundMessages save(HeadquarterDTO headquarterDTO) throws FoodTainerException {
        Headquarter headquarter = new Headquarter();
        try {
            if (!headquarterDTO.getName().isBlank() && !headquarterDTO.getDescription().isBlank() && !headquarterDTO.getSchedule().isBlank() && !headquarterDTO.getType().isBlank()) {
                headquarter.setNameHeadquarter(headquarterDTO.getName());
                headquarter.setDescriptionHeadquarter(headquarterDTO.getDescription());
                headquarter.setScheduleHeadquarter(headquarterDTO.getSchedule());
                headquarter.setTypeHeadquarter(headquarterDTO.getType());
                Optional<Picture> picture = pictureRepository.findById(headquarterDTO.getPicture().getId());
                if (picture.isPresent()) {
                    headquarter.setPicture(picture.get());
                } else {
                    return new OutboundMessages(HeadquarterConstants.PICTURE_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<City> city = cityRepository.findById(headquarterDTO.getCity().getId());
                if (city.isPresent()) {
                    headquarter.setCity(city.get());
                } else {
                    return new OutboundMessages(HeadquarterConstants.CITY_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Contact> contact = contactRepository.findById(headquarterDTO.getContact().getId());
                if (contact.isPresent()) {
                    headquarter.setContact(contact.get());
                } else {
                    return new OutboundMessages(HeadquarterConstants.CONTACT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Restaurant> restaurant = restaurantRepository.findById(headquarterDTO.getRestaurant().getId());
                if (restaurant.isPresent()) {
                    headquarter.setRestaurant(restaurant.get());
                } else {
                    return new OutboundMessages(HeadquarterConstants.RESTAURANT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                Optional<Location> location = locationRepository.findById(headquarterDTO.getLocation().getId());
                if (location.isPresent()) {
                    headquarter.setLocation(location.get());
                } else {
                    return new OutboundMessages(HeadquarterConstants.LOCATION_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
                }
                headquarterRepository.save(headquarter);
            } else {
                return new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
            }
        } catch (Exception exception) {
            throw new FoodTainerException(HeadquarterConstants.ERROR_SAVING, exception);
        }
        return new OutboundMessages(HeadquarterConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
    }

    @Override
    public ConsultHeadquarterResponseDTO findById(int id) throws FoodTainerException {
        ConsultHeadquarterResponseDTO response = new ConsultHeadquarterResponseDTO();
        Headquarter headquarter = headquarterRepository.getReferenceById(id);
        response.setHeadquarter(MapperUtil.entityToDtoHeadquarter(headquarter));
        response.setProducts(productService.findByIdRestaurant(headquarter.getRestaurant().getIdRestaurant()));
        response.setQualifications(qualificationService.findByIdRestaurant(headquarter.getRestaurant().getIdRestaurant()));
        return response;
    }


}
