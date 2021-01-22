package andrei.teplyh.security;

import andrei.teplyh.entity.User;
import andrei.teplyh.security.jwt.JwtUserFactory;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found.", login));
        }

        return JwtUserFactory.createJwtUser(user);
    }
}
