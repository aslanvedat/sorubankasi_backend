package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.SorubankasiRequestDTO;
import proje.sorubankasi.dto.response.SorubankasiResponseDTO;
import proje.sorubankasi.entity.SoruBankasi;

public interface SorubankasiService {
    SoruBankasi saveSorubankasi(SorubankasiRequestDTO sorubankasiRequestDTO);

    SoruBankasi updateSorubankasi(long sorubankasi_id, SorubankasiRequestDTO sorubankasiRequestDTO);

    SoruBankasi deleteById(long sorubankasi_id);

    SoruBankasi addTest(long sorubankasi_id, long test_id);
    SoruBankasi findById(long id);

    SoruBankasi deleteTest(long sorubankasi_id, long test_id);
    SorubankasiResponseDTO viewSorubankasi(long sorubankasi_id);
}
