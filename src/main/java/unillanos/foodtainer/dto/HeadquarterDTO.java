package unillanos.foodtainer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadquarterDTO {

    private int id;

    private String name;

    private String description;

    private String schedule;

    private String type;

    private PictureDTO picture;

    private CityDTO city;

    private LocationDTO location;

    private RestaurantDTO restaurant;

    private ContactDTO contact;


}
