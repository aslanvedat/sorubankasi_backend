package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.UserRequestDTO;
import proje.sorubankasi.dto.response.UserResponseDTO;
import proje.sorubankasi.entity.User;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.UserRepostory;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepostory repository;


    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> userOptional = repository.findById(id);
        return userOptional.orElseThrow(() -> new ApiRequestException("user is not found"));
    }

    @Override
    public UserResponseDTO save(UserRequestDTO request) {
        //buraya ekleme yapidi validation için
        if (repository.existsByMail(request.getMail())) {
            throw new ApiRequestException("This user already exist!");
        }
        if(!request.getPassword().equals(request.getPasswordTekrar())){
            throw  new ApiRequestException("this password can not match");
        }
        var theUser = new User(request);
        var savedUser = repository.save(theUser);
        return new UserResponseDTO(savedUser);
    }

    @Override
    public User save(User user) {

        if (repository.existsByMail(user.getMail())) {
            throw new ApiRequestException("This user already exist!");
        }
        return repository.save(user);
    }

    @Override
    public UserResponseDTO deleteById(long id) {
        var user = findById(id);
        repository.delete(user);
        return new UserResponseDTO(user);
    }

    @Override
    public boolean existByMail(String mail) {
        return repository.existsByMail(mail);
    }

    //user yerine userResponseDTO olabilir
    @Override
    public UserResponseDTO update(long user_id, UserRequestDTO request) {
        User theUser = findById(user_id);
        User user = new User(request);
        user.setId(theUser.getId());
        var updateUser = repository.save(user);
        return new UserResponseDTO(updateUser);
    }


}
