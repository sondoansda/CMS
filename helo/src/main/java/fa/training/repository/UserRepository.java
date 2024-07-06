package fa.training.repository;

import fa.training.entity.Content;
import fa.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword( String email, String password);

}
