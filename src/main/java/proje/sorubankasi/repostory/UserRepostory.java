package proje.sorubankasi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.sorubankasi.entity.User;

@Repository
public interface UserRepostory extends JpaRepository<User,Long> {
}
