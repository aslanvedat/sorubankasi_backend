package proje.sorubankasi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import proje.sorubankasi.entity.Soru;

public interface SoruRepostory extends JpaRepository<Soru,Long> {

}
