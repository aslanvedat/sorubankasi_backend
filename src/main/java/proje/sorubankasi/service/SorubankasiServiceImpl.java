package proje.sorubankasi.service;

import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.SorubankasiRequestDTO;
import proje.sorubankasi.dto.response.SorubankasiResponseDTO;
import proje.sorubankasi.entity.SoruBankasi;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.SorubankasiRepostory;

import java.util.Optional;

@Service
public class SorubankasiServiceImpl implements SorubankasiService {
    private final SorubankasiRepostory sorubankasiRepostory;

    private final TestService testService;

    public SorubankasiServiceImpl(SorubankasiRepostory sorubankasiRepostory, TestService testService) {
        this.sorubankasiRepostory = sorubankasiRepostory;
        this.testService = testService;
    }


    @Override
    public SoruBankasi saveSorubankasi(SorubankasiRequestDTO sorubankasiRequestDTO) {
        SoruBankasi soruBankasi = new SoruBankasi();

        soruBankasi.setName(sorubankasiRequestDTO.getName());

//test te sorularin eklnemesi gibi burayada testler eklendikten sora bazi degisiklikler yapilabilir
        soruBankasi.setTests(sorubankasiRequestDTO.getTest());
        return sorubankasiRepostory.save(soruBankasi);
    }

    @Override
    public SoruBankasi updateSorubankasi(long sorubankasi_id, SorubankasiRequestDTO sorubankasiRequestDTO) {
        Optional<SoruBankasi> updateSorubankasi = sorubankasiRepostory.findById(sorubankasi_id);
        if (!updateSorubankasi.isPresent()) {
            throw new ApiRequestException("sorubankasi not found:" + sorubankasi_id);
        }
        SoruBankasi soruBankasi = new SoruBankasi();
        soruBankasi.setName(sorubankasiRequestDTO.getName());
        soruBankasi.setTests(sorubankasiRequestDTO.getTest());
        return sorubankasiRepostory.save(soruBankasi);

    }

    @Override
    public SoruBankasi deleteById(long sorubankasi_id) {
        Optional<SoruBankasi> deleteSorubankasi = sorubankasiRepostory.findById(sorubankasi_id);
        if (!deleteSorubankasi.isPresent()) {
            throw new ApiRequestException("sorubankasi not found:" + sorubankasi_id);
        }

        sorubankasiRepostory.deleteById(sorubankasi_id);
        return deleteSorubankasi.get();
    }

    @Override
    public SoruBankasi findById(long id) {
        Optional<SoruBankasi> soruBankasiOptional = sorubankasiRepostory.findById(id);
        //return soruBankasiOptional.orElseThrow(()->new RuntimeException("sorubankasi not found"));
        return soruBankasiOptional.orElseThrow(() -> new ApiRequestException("sorubankasi is not found"));

    }

    @Override
    public SoruBankasi addTest(long sorubankasi_id, long test_id) {
        var sorubankasi = findById(sorubankasi_id);
        var test = testService.findById(test_id);
        sorubankasi.getTests().add(test);
        return sorubankasiRepostory.save(sorubankasi);
    }


    @Override
    public SoruBankasi deleteTest(long sorubankasi_id, long test_id) {
        var sorubankasi = findById(sorubankasi_id);
        var test = testService.findById(test_id);
        test.getQuestions().remove(test);
        return sorubankasi;
    }

    @Override
    public SorubankasiResponseDTO viewSorubankasi(long sorubankasi_id) {
        var sorubankasi = findById(sorubankasi_id);
        return new SorubankasiResponseDTO(sorubankasi);

    }


}
