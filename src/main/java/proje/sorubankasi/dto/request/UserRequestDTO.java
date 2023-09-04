package proje.sorubankasi.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Mail cannot be empty")
    @Email(message = "mail is not valid")
    private String mail;
    @NotBlank(message = "Password cannot be empty")
    //en az 5 karekter olmali ve buyuk harf barindirmali
    @Pattern(regexp = "^(?=.*[A-Z]).{5,}$" ,message = "password is not valid")
    private String password;

    @Pattern(regexp = "^(?=.*[A-Z]).{5,}$" ,message = "password is not valid")
    private String passwordTekrar;
}
