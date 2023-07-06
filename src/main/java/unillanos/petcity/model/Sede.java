package unillanos.petcity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sede")
public class Sede {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sede")
    private int idHeadquarter;

    @Column(name = "name_sede")
    private String nameHeadquarter;

    @Column(name = "description_sede")
    private String descriptionHeadquarter;

    @Column(name = "schedule_sede")
    private String scheduleHeadquarter;

    @Column(name = "type_sede")
    private String typeHeadquarter;

    @ManyToOne
    @JoinColumn(name = "id_image", referencedColumnName = "id_image", nullable = false)
    private Image picture;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "id_petshop", referencedColumnName = "id_petshop", nullable = false)
    private Petshop restaurant;

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact", nullable = false)
    private Contact contact;

}
