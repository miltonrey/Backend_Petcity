package unillanos.petcity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private int id;

    private String phone;

    private UserDTO user;

    private String urlFacebook;

    private String urlInstagram;

    private String urlWebpage;

}
