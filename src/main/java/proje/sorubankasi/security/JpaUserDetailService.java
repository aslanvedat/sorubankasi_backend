package proje.sorubankasi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.repostory.UserRepostory;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepostory userRepostory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepostory.findByMail(email).map(UserSecurity::new).orElseThrow(()-> new ApiRequestException("User Not Found!"));
    }
}
