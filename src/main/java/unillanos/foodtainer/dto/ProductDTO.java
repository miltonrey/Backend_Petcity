package unillanos.foodtainer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int id;

    private String name;

    private String description;

    private String type;

    private RestaurantDTO restaurant;

    private PictureDTO picture;

}
