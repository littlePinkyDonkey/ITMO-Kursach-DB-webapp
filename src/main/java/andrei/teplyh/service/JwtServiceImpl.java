package andrei.teplyh.service;

import andrei.teplyh.dto.UserDTO;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements UserDetailsService, JwtService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * моя кастомная реализация получения пользователя по логину
     **/
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public String login(UserDTO user) {
        return null;
    }

    @Override
    public String login(UserDTO user, long id) {
        return null;
    }

    @Override
    public void logout(String login) {

    }

    @Override
    public Date loadLastLogout(String login) {
        return null;
    }
}
