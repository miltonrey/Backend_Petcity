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
@Table(name = "customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "name_customer")
    private String nameCustomer;

    @ManyToOne
    @JoinColumn(name = "email_customer", referencedColumnName = "email_user", nullable = false)
    private User emailCustomer;

}
