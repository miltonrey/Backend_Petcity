package unillanos.petcity.util;

import unillanos.petcity.dto.*;
import unillanos.petcity.model.*;

import java.util.ArrayList;
import java.util.List;

public class MapperUtil {

    private MapperUtil() {
        throw new IllegalStateException("Utility class for mapping.");
    }

    public static DepartmentDTO entityToDtoDepartment(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setIdDepartment(department.getIdDepartment());
        departmentDTO.setNameDepartment(department.getNameDepartment());
        return departmentDTO;
    }

    public static PictureDTO entityToDtoPicture(Image picture) {
        PictureDTO pictureDTO = new PictureDTO();
        pictureDTO.setId(picture.getIdPicture());
        pictureDTO.setName(picture.getNamePicture());
        pictureDTO.setDescription(picture.getDescriptionPicture());
        pictureDTO.setPicture(picture.getPicture());
        return pictureDTO;
    }

    public static UserDTO entityToDtoUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmailUser());
        userDTO.setPassword(user.getPasswordUser());
        userDTO.setName(user.getNameUser());
        userDTO.setLastname(user.getLastName());
        userDTO.setTypeUser(user.getTypeUser());
        return userDTO;
    }

    public static LocationDTO entityToDtoLocation(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getIdLocation());
        locationDTO.setUrl(location.getUrl());
        return locationDTO;
    }

    public static PetshopDTO entityToDtoRestaurant(Petshop restaurant) {
        PetshopDTO petshopDTO = new PetshopDTO();
        petshopDTO.setId(restaurant.getIdRestaurant());
        petshopDTO.setName(restaurant.getNameRestaurant());
        petshopDTO.setEmail(restaurant.getEmailRestaurant().getEmailUser());
        return petshopDTO;
    }

    public static ContactDTO entityToDtoContact(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getIdContact());
        contactDTO.setPhone(contact.getPhoneContact());
        contactDTO.setUser(entityToDtoUser(contact.getEmailContact()));
        contactDTO.setUrlInstagram(contactDTO.getUrlInstagram());
        return contactDTO;
    }

    public static HeadquarterDTO entityToDtoHeadquarter(Sede headquarter) {
        HeadquarterDTO headquarterDTO = new HeadquarterDTO();
        headquarterDTO.setId(headquarter.getIdHeadquarter());
        headquarterDTO.setName(headquarter.getNameHeadquarter());
        headquarterDTO.setDescription(headquarter.getDescriptionHeadquarter());
        headquarterDTO.setSchedule(headquarter.getScheduleHeadquarter());
        headquarterDTO.setType(headquarter.getTypeHeadquarter());
        headquarterDTO.setPicture(entityToDtoPicture(headquarter.getPicture()));
        headquarterDTO.setLocation(entityToDtoLocation(headquarter.getLocation()));
        headquarterDTO.setPetshop(entityToDtoRestaurant(headquarter.getRestaurant()));
        headquarterDTO.setContact(entityToDtoContact(headquarter.getContact()));
        return headquarterDTO;
    }

    public static ProductDTO entityToDtoProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getIdProduct());
        productDTO.setName(product.getNameProduct());
        productDTO.setDescription(product.getDescriptionProduct());
        productDTO.setType(product.getTypeProduct());
        productDTO.setRestaurant(entityToDtoRestaurant(product.getRestaurant()));
        productDTO.setPicture(entityToDtoPicture(product.getPicture()));
        return productDTO;
    }

    public static QualificationDTO entityToDtoQualification(Qualification qualification) {
        QualificationDTO qualificationDTO = new QualificationDTO();
        qualificationDTO.setIdQualification(qualification.getIdQualification());
        qualificationDTO.setScore(qualification.getScoreQualification());
        qualificationDTO.setComment(qualification.getCommentQualification());
        qualificationDTO.setCustomer(new CustomerDTO(qualification.getCustomer().getIdCustomer(), qualification.getCustomer().getNameCustomer(), qualification.getCustomer().getEmailCustomer().getEmailUser()));
        return qualificationDTO;
    }


    public static List<ProductDTO> entityToDtoProductList(List<Product> products) {
        List<ProductDTO> response = new ArrayList<>();
        for (Product product : products) {
            response.add(entityToDtoProduct(product));
        }
        return response;
    }

    public static List<QualificationDTO> entityToDtoQualificationList(List<Qualification> qualifications) {
        List<QualificationDTO> response = new ArrayList<>();
        for (Qualification qualification : qualifications) {
            response.add(entityToDtoQualification(qualification));
        }
        return response;
    }


}

