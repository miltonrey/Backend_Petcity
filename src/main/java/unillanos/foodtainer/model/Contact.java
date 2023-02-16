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
@Table(name = "contact")
public class Contact {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contact")
    private int idContact;

    @Column(name = "phone_contact")
    private String phoneContact;

    @ManyToOne
    @JoinColumn(name = "email_contact", referencedColumnName = "email_user", nullable = false)
    private User emailContact;

    @Column(name = "url_facebook")
    private String urlFacebook;

    @Column(name = "url_instagram")
    private String urlInstagram;

    @Column(name = "url_webpage")
    private String urlWebpage;

}
