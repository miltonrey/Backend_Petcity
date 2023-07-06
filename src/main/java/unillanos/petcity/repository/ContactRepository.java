package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
