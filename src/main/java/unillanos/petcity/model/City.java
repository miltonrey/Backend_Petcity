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
@Table(name = "city")
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city")
    private int idCity;

    @Column(name = "name_city")
    private String nameCity;

    @ManyToOne
    @JoinColumn(name = "ID_DEPARTMENT",  referencedColumnName = "ID_DEPARTMENT", nullable = false)
    private Department department;

}
