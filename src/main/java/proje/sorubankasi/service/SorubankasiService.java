package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.SorubankasiRequestDTO;
import proje.sorubankasi.entity.SoruBankasi;

public interface SorubankasiService {
   SoruBankasi saveSorubankasi(SorubankasiRequestDTO sorubankasiRequestDTO);
   SoruBankasi updateSorubankasi(long sorubankasi_id,SorubankasiRequestDTO sorubankasiRequestDTO);
SoruBankasi deleteById(long sorubankasi_id);

}
