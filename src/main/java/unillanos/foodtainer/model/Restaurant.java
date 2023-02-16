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
@Table(name = "restaurant")
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_restaurant")
    private int idRestaurant;

    @Column(name = "name_restaurant")
    private String nameRestaurant;

    @ManyToOne
    @JoinColumn(name = "email_restaurant", referencedColumnName = "email_user", nullable = false)
    private User emailRestaurant;

}
