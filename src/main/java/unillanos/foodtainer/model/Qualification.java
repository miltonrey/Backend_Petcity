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
public class Qualification {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_qualification")
    private int idQualification;

    @Column(name = "score_qualification")
    private double scoreQualification;

    @Column(name = "comment_qualification")
    private String commentQualification;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", nullable = false)
    private Customer customer;

}
