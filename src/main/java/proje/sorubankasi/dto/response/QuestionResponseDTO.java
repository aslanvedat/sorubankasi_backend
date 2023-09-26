package proje.sorubankasi.dto.response;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import proje.sorubankasi.entity.Question;

import java.util.HashMap;
import java.util.Map;

@Data
public class QuestionResponseDTO {
    private Long id;
    private String text;
    private Map<Character, String> options;


    public QuestionResponseDTO(Question question) {
        this.id = question.getId();
        this.text = question.getText();
        this.options = convertOptionsStringToMap(question.getOptions());
    }

    //a=asdfa;b=asdfasdf
    private Map<Character, String> convertOptionsStringToMap(String str) {
        String[] values = str.split(";");
        //   String [] options=new String[values.length];
        Map<Character, String> optionsMap = new HashMap<>();


        for (int i = 0; i < values.length; i++) {
            String[] result = values[i].split("=");
            char key = result[0].charAt(0); // İlk karakteri anahtar olarak kullan
            String val = result[1];
            optionsMap.put(key, val);
            //  options[i]=result[0];
        }
        return optionsMap;
    }

}
