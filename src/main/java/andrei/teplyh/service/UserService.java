package andrei.teplyh.service;

import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.entity.User;

import java.util.List;

public interface UserService {
    int registerUser(RegistrationUserDTO user);

    User findUserByLogin(String login);

    boolean deleteUser(int mainWorkerId);

    boolean addRolesToUser(int userId, List<String> roles);
}
