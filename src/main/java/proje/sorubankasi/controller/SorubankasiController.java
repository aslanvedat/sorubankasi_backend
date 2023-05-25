package proje.sorubankasi.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proje.sorubankasi.dto.request.SorubankasiRequestDTO;
import proje.sorubankasi.entity.SoruBankasi;
import proje.sorubankasi.service.SorubankasiService;

@RestController
@RequestMapping("/sorubankasi")
public class SorubankasiController {
    private SorubankasiService sorubankasiService;

    public SorubankasiController(SorubankasiService sorubankasiService) {
        this.sorubankasiService = sorubankasiService;
    }

    @PostMapping("/")
    public ResponseEntity<SoruBankasi> saveSorubankasi(@RequestBody SorubankasiRequestDTO input) {
        var saveSorubankasi = sorubankasiService.saveSorubankasi(input);
        return new ResponseEntity<SoruBankasi>(saveSorubankasi, HttpStatus.CREATED);
    }

    @PutMapping("/{sorubankasi_id}")
    public ResponseEntity<SoruBankasi> updateSorubankasi(@PathVariable long sorubankasi_id, @RequestBody SorubankasiRequestDTO input) {
        var updateSorubankasi = sorubankasiService.updateSorubankasi(sorubankasi_id, input);
        return new ResponseEntity<SoruBankasi>(updateSorubankasi, HttpStatus.OK);
    }

    @DeleteMapping("/{sorubankasi_id")
    public ResponseEntity<SoruBankasi> deleteSorubankasi(@PathVariable long sorubankasi_id) {
        var deleteSorubankasi = sorubankasiService.deleteById(sorubankasi_id);
        return new ResponseEntity<SoruBankasi>(deleteSorubankasi, HttpStatus.OK);

    }

}
