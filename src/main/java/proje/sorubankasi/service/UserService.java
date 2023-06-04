package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    Collection<User> findAll();

    UserResponseDTO save(UserRequestDTO request);
}
