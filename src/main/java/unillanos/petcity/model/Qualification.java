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
@Table(name = "calification")
public class Qualification {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_calification")
    private int idQualification;

    @Column(name = "star_calification")
    private double scoreQualification;

    @Column(name = "comment_calification")
    private String commentQualification;

    @ManyToOne
    @JoinColumn(name = "id_petshop", referencedColumnName = "id_petshop", nullable = false)
    private Petshop restaurant;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", nullable = false)
    private Customer customer;

}
