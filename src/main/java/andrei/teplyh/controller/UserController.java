package andrei.teplyh.controller;

import andrei.teplyh.dto.AuthUserDTO;
import andrei.teplyh.dto.RegistUserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.entity.enums.UserRoles;
import andrei.teplyh.repository.RolesRepository;
import andrei.teplyh.security.jwt.util.JwtTokenProvider;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class UserController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final RolesRepository rolesRepository;

    @Autowired
    public UserController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserService userService,
            RolesRepository rolesRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.rolesRepository = rolesRepository;
    }

    @PostMapping(path = "/auth", produces = "application/json")
    public ResponseEntity signIn(@RequestBody AuthUserDTO authUserDTO) {
        try {
            String login = authUserDTO.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, authUserDTO.getPassword()));

            User user = userService.findUserByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }

            String token = jwtTokenProvider.createToken(login, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping(path = "/regist", produces = "application/json")
    public ResponseEntity signUp(@RequestBody RegistUserDTO registUserDTO) {
        int userId = userService.registerUser(registUserDTO);
        rolesRepository.addRoleToUser(userId, UserRoles.STORYBOARD_ARTIST.getDescription());
        rolesRepository.addRoleToUser(userId, UserRoles.REGISSEUR.getDescription());
        return null;
    }

    @PostMapping(path = "/test")
    public String test(@RequestAttribute(name = "login") String login) {
        System.out.println(login);
        return login;
    }

    @PostMapping(path = "/test2")
    public String test() {
        return "asd";
    }
}
