package unillanos.petcity.model;

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
@Table(name = "image")
public class Image {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_image")
    private int idPicture;

    @Column(name = "name_image")
    private String namePicture;

    @Column(name = "description_image")
    private String descriptionPicture;

    @Column(name = "image")
    private byte[] picture;

}
