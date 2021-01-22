package andrei.teplyh.service.impl;

import andrei.teplyh.dto.AuthUserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.security.jwt.util.JwtTokenProvider;
import andrei.teplyh.service.AuthenticationService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationServiceImpl(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserService userService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @Override
    public Map<String, String> singIn(AuthUserDTO authUserDTO) throws AuthenticationException {
        String login = authUserDTO.getLogin();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, authUserDTO.getPassword()));

        User user = userService.findUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String token = jwtTokenProvider.createToken(login, user.getRoles());

        Map<String, String> response = new HashMap<>();
        response.put("login", login);
        response.put("token", token);

        return response;
    }
}
