package proje.sorubankasi.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Mail cannot be empty")
    private String mail;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
