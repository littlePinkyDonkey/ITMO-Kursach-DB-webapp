package andrei.teplyh.service;

import andrei.teplyh.dto.RegistUserDTO;
import andrei.teplyh.entity.User;

import java.util.List;

public interface UserService {
    int registerUser(RegistUserDTO user);

    User findUserByLogin(String login);

    boolean deleteUser(int mainWorkerId);

    boolean addRolesToUser(int userId, List<String> roles);
}
