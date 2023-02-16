package unillanos.foodtainer.model;

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
@Table(name = "headquarter")
public class Headquarter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_headquarter")
    private int idHeadquarter;

    @Column(name = "name_headquarter")
    private String nameHeadquarter;

    @Column(name = "description_headquarter")
    private String descriptionHeadquarter;

    @Column(name = "schedule_headquarter")
    private String scheduleHeadquarter;

    @Column(name = "type_headquarter")
    private String typeHeadquarter;

    @ManyToOne
    @JoinColumn(name = "id_picture", referencedColumnName = "id_picture", nullable = false)
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "id_contact", referencedColumnName = "id_contact", nullable = false)
    private Contact contact;

}
