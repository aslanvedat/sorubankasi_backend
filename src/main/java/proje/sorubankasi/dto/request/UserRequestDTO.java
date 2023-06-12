package proje.sorubankasi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    private String name;
    private String mail;
    private String password;
}
