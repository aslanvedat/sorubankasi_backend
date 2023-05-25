package proje.sorubankasi.dto.request;
import lombok.Data;
import proje.sorubankasi.entity.Test;
import java.util.List;

@Data
public class SorubankasiRequestDTO {
    private  Long id;
    private String name;
    private List<Test> test;


}
