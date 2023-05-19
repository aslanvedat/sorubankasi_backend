package proje.sorubankasi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proje.sorubankasi.entity.SoruBankasi;

@Repository
public interface SorubankasiRepostory extends JpaRepository<SoruBankasi,Long> {
}
