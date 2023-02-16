package unillanos.foodtainer.headquarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import unillanos.foodtainer.constants.GlobalConstants;
import unillanos.foodtainer.constants.HeadquarterConstants;
import unillanos.foodtainer.constants.StatusCodeConstants;
import unillanos.foodtainer.dto.*;
import unillanos.foodtainer.exceptions.FoodTainerException;
import unillanos.foodtainer.model.*;
import unillanos.foodtainer.repository.*;
import unillanos.foodtainer.service.HeadquarterService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HeadquarterServiceTest {

    @Autowired
    private HeadquarterService headquarterService;

    @MockBean
    HeadquarterRepository headquarterRepository;

    @MockBean
    PictureRepository pictureRepository;

    @MockBean
    CityRepository cityRepository;

    @MockBean
    LocationRepository locationRepository;

    @MockBean
    RestaurantRepository restaurantRepository;

    @MockBean
    ContactRepository contactRepository;

    @Test
    void saveSuccessfullyTest() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.SUCCESSFULLY_SAVED, StatusCodeConstants.STATUS_OK);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }


    @Test
    void saveNotName() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotDescription() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotSchedule() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }


    @Test
    void saveNotType() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(GlobalConstants.OBLIGATORY_FIELD, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotPicture() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.PICTURE_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.empty());
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotLocation() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.LOCATION_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.empty());
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotCity() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.CITY_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.empty());
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotRestaurant() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.RESTAURANT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.empty());
        when(contactRepository.findById(1)).thenReturn(Optional.of(new Contact()));
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

    @Test
    void saveNotContact() throws FoodTainerException {
        OutboundMessages expected = new OutboundMessages(HeadquarterConstants.CONTACT_NOT_FOUND, StatusCodeConstants.BAD_REQUEST);
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(1);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(1);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(1);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(1);
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(1);
        HeadquarterDTO headquarterDTO = new HeadquarterDTO(1,
                "Burger POP Foodtruck",
                "Sede de Burger POP en ubicada en Foodtruck Villavicencio.",
                "Lunes a viernes: 4pm - 10pm ",
                "Comida rápida, Hamburguesas",
                pictureDTO, cityDTO, locationDTO, restaurantDTO, contactDTO);
        when(pictureRepository.findById(1)).thenReturn(Optional.of(new Picture()));
        when(locationRepository.findById(1)).thenReturn(Optional.of(new Location()));
        when(cityRepository.findById(1)).thenReturn(Optional.of(new City()));
        when(restaurantRepository.findById(1)).thenReturn(Optional.of(new Restaurant()));
        when(contactRepository.findById(1)).thenReturn(Optional.empty());
        OutboundMessages actual = headquarterService.save(headquarterDTO);
        assertEquals(expected, actual);
    }

}
