package andrei.teplyh.service.authentication;

import andrei.teplyh.dto.AuthUserDTO;

import java.util.Map;

public interface AuthenticationService {
    Map<String, Object> singIn(AuthUserDTO authUserDTO);
}
