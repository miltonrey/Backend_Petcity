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
@Table(name = "petshop")
public class Petshop {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_petshop")
    private int idRestaurant;

    @Column(name = "name_petshop")
    private String nameRestaurant;

    @ManyToOne
    @JoinColumn(name = "email_petshop", referencedColumnName = "email_user", nullable = false)
    private User emailRestaurant;

}
