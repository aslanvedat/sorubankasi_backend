package proje.sorubankasi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.sorubankasi.entity.Role;

@Repository
public interface RoleRepostory extends JpaRepository<Role,Long> {
}
