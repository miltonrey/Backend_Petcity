package unillanos.petcity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String email;

    private String password;

    private String typeUser;

    private String name;

    private String lastname;

}
