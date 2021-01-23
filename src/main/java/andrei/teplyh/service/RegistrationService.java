package andrei.teplyh.service;

import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.exceptions.UserAlreadyExistsException;

public interface RegistrationService {
    void signUp(RegistrationUserDTO registrationUserDTO) throws UserAlreadyExistsException;
}
