package unillanos.petcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unillanos.petcity.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.emailUser = ?1 AND u.passwordUser = ?2")
    User findByEmailUserAndPasswordUser(String email, String password);

    Optional<User> findOneByEmailUser(String email);

}
