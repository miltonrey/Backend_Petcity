package unillanos.foodtainer.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "picture")
public class Picture {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_picture")
    private int idPicture;

    @Column(name = "name_picture")
    private String namePicture;

    @Column(name = "description_picture")
    private String descriptionPicture;

    @Column(name = "picture")
    private byte[] picture;

}
