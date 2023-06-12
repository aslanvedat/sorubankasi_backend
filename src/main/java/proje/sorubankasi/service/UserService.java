package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.entity.User;

import java.util.Collection;

public interface UserService {
    Collection<User> findAll();

    User findById(long id);

    UserResponseDTO save(UserRequestDTO request);

    User save(User user);

    UserResponseDTO update(long user_id, UserRequestDTO requestDTO);

    UserResponseDTO deleteById(long id);

    boolean existByMail(String mail);
}
