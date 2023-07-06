package unillanos.petcity.dto;

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

    private PetshopDTO restaurant;

    private PictureDTO picture;

}
