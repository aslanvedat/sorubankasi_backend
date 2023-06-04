package proje.sorubankasi.dto.response;

import lombok.Data;
import proje.sorubankasi.entity.User;

@Data
public class UserResponseDTO {

    private long id;
    private String name;
    private String mail;


    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.mail = user.getMail();
    }
}
