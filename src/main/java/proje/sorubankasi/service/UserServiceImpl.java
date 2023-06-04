package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.entity.User;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.UserRepostory;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepostory repository;

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public UserResponseDTO save( UserRequestDTO request) {

        if(repository.existsByMail(request.getMail())){
            throw new ApiRequestException("This user already exist!");
        }

        var theUser = new User(request);
        var savedUser = repository.save(theUser);

        return new UserResponseDTO(savedUser);
    }


}
