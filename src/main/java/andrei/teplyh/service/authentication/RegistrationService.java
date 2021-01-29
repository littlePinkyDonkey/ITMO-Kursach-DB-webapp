package andrei.teplyh.service.authentication;

import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.exceptions.UserAlreadyExistsException;

public interface RegistrationService {
    void signUp(RegistrationUserDTO registrationUserDTO) throws UserAlreadyExistsException;
}
