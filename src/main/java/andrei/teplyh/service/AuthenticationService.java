package andrei.teplyh.service;

import andrei.teplyh.dto.AuthUserDTO;

import java.util.Map;

public interface AuthenticationService {
    Map<String, String> singIn(AuthUserDTO authUserDTO);
}
