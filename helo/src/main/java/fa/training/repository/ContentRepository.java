package fa.training.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import fa.training.entity.Content;


import org.springframework.stereotype.Repository;
import java.util.Set;


@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
     Content findByTitle(String title);

}
