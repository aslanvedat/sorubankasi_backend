package proje.sorubankasi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.sorubankasi.entity.Question;

@Repository
public interface QuestionRepostory extends JpaRepository<Question,Long> {

}
