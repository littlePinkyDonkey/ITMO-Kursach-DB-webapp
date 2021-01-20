package andrei.teplyh.service;

import andrei.teplyh.dto.UserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JwtServiceImpl implements UserDetailsService, JwtService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found", login));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    @Override
    public String login(UserDTO user) {
        User entity = userRepository.getUserByLogin(user.getLogin());
        if (entity != null) {
            long id = entity.getUserId();
            return login(user, id);
        } else {
            throw new BadCredentialsException("Bad login");
        }
    }

    @Override
    public String login(UserDTO user, long id) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
        UserDetails userDetails = loadUserByUsername(user.getLogin());
        String token = jwtUtil.generateToken(userDetails.getUsername(), id);
        return token;
    }

    @Override
    public void logout(String login) {
        User entity = userRepository.getUserByLogin(login);

        Date lastLogout = new Date();
        entity.setLastLogOut(lastLogout);

        //перезапись последнего времени авторизации???
        //userRepository.save(entity);
    }

    @Override
    public Date loadLastLogout(String login) {
        User entity = userRepository.getUserByLogin(login);
        return entity.getLastLogOut();
    }
}
