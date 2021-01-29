package andrei.teplyh.controller;

import andrei.teplyh.dto.AuthUserDTO;
import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.entity.enums.UserRoles;
import andrei.teplyh.exceptions.UserAlreadyExistsException;
import andrei.teplyh.service.authentication.AuthenticationService;
import andrei.teplyh.service.authentication.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthenticationService authenticationService;

    private final RegistrationService registrationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService, RegistrationService registrationService) {
        this.authenticationService = authenticationService;
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity signIn(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Map<String, Object> response = authenticationService.singIn(authUserDTO);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid username or password");
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
