package proje.sorubankasi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.sorubankasi.entity.User;

import java.util.Optional;

@Repository
public interface UserRepostory extends JpaRepository<User,Long> {

    Optional<User> findByMail(String mail);

    boolean existsByMail(String mail);
}
