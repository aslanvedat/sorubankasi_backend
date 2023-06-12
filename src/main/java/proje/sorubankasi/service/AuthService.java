package proje.sorubankasi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import proje.sorubankasi.dto.request.AuthRequestDTO;
import proje.sorubankasi.exception.ApiRequestException;
import proje.sorubankasi.security.JpaUserDetailService;
import proje.sorubankasi.security.JwtUtils;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JpaUserDetailService jpaUserDetailsService;

    private final JwtUtils jwtUtils;

    public String authenticate(AuthRequestDTO requestDTO) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getMail(), requestDTO.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(requestDTO.getMail());
            if (user != null) {
                return jwtUtils.generateToken(user);

            }
            throw new ApiRequestException("Error authentication");
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage(), e);
        }
    }

}
