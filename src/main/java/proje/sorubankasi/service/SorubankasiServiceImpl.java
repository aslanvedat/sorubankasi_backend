package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.SorubankasiRequestDTO;
import proje.sorubankasi.entity.SoruBankasi;
import proje.sorubankasi.repostory.SorubankasiRepostory;

import java.util.Optional;

public class SorubankasiServiceImpl implements SorubankasiService {
  private  final SorubankasiRepostory sorubankasiRepostory;

    public SorubankasiServiceImpl(SorubankasiRepostory sorubankasiRepostory) {
        this.sorubankasiRepostory = sorubankasiRepostory;
    }


    @Override
    public SoruBankasi saveSorubankasi(SorubankasiRequestDTO sorubankasiRequestDTO) {
SoruBankasi soruBankasi =new SoruBankasi();

soruBankasi.setName(sorubankasiRequestDTO.getName());

//test te sorularin eklnemesi gibi burayada testler eklendikten sora bazi degisiklikler yapilabilir
soruBankasi.setTests(sorubankasiRequestDTO.getTest());
        return sorubankasiRepostory.save(soruBankasi);
    }

    @Override
    public SoruBankasi updateSorubankasi(long sorubankasi_id, SorubankasiRequestDTO sorubankasiRequestDTO) {
        Optional<SoruBankasi> updateSorubankasi=sorubankasiRepostory.findById(sorubankasi_id);
        if(!updateSorubankasi.isPresent()){
            throw new RuntimeException("sorubankasi not found:"+sorubankasi_id);
        }
        SoruBankasi soruBankasi=new SoruBankasi();

        soruBankasi.setName(sorubankasiRequestDTO.getName());
        soruBankasi.setTests(sorubankasiRequestDTO.getTest());
    return sorubankasiRepostory.save(soruBankasi);

    }

    @Override
    public SoruBankasi deleteById(long sorubankasi_id) {
        Optional<SoruBankasi>deleteSorubankasi=sorubankasiRepostory.findById(sorubankasi_id);
        if (!deleteSorubankasi.isPresent()){
            throw  new RuntimeException("sorubankasi not found:"+sorubankasi_id);
        }

         sorubankasiRepostory.deleteById(sorubankasi_id);
        return deleteSorubankasi.get();
    }


}
