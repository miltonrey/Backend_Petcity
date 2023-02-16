package unillanos.foodtainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unillanos.foodtainer.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
