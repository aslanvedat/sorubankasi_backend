package proje.sorubankasi.dto.response;

import lombok.Data;
import proje.sorubankasi.entity.SoruBankasi;

import java.util.List;

@Data
public class SorubankasiResponseDTO {


    private Long id ;
    private String name;
    private List<TestResponseDTO>tests;

    public SorubankasiResponseDTO(Long id, String name, List<TestResponseDTO> tests) {
        this.id = id;
        this.name = name;
        this.tests = tests;
    }

    public SorubankasiResponseDTO(SoruBankasi soruBankasi){
        this.id= soruBankasi.getId();
        this.name=soruBankasi.getName();
        this.tests=soruBankasi.getTests().stream().map(TestResponseDTO::new).toList();
    }
}
