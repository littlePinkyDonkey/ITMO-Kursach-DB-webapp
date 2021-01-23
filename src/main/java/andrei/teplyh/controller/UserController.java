package andrei.teplyh.controller;

import andrei.teplyh.dto.AuthUserDTO;
import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.entity.enums.UserRoles;
import andrei.teplyh.exceptions.UserAlreadyExistsException;
import andrei.teplyh.repository.RolesRepository;
import andrei.teplyh.repository.workers.WorkersRepository;
import andrei.teplyh.security.jwt.util.JwtTokenProvider;
import andrei.teplyh.service.AuthenticationService;
import andrei.teplyh.service.RegistrationService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final AuthenticationService authenticationService;

    private final RegistrationService registrationService;

    @Autowired
    public UserController(AuthenticationService authenticationService, RegistrationService registrationService) {
        this.authenticationService = authenticationService;
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity signIn(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Map<String, Object> response = authenticationService.singIn(authUserDTO);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping(path = "/registration", produces = "application/json")
    public ResponseEntity signUp(@RequestBody RegistrationUserDTO registrationUserDTO) {
        try {
            registrationService.signUp(registrationUserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/roles", produces = "application/json")
    public ResponseEntity getRoles() {
        return ResponseEntity.ok().body(UserRoles.getAllRoles());
    }
}
