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
@Table(name = "product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "description_product")
    private String descriptionProduct;

    @Column(name = "type_product")
    private String typeProduct;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", referencedColumnName = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "id_picture", referencedColumnName = "id_picture", nullable = false)
    private Picture picture;

}
