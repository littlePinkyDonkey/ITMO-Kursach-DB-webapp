package andrei.teplyh.service.impl;

import andrei.teplyh.dto.RegistUserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.repository.RolesRepository;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public int registerUser(RegistUserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.addUser(
                user.getWorkerId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                "~/",
                new Date()
        );
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public boolean deleteUser(int mainWorkerId) {
        return userRepository.deleteUser(mainWorkerId);
    }

    @Override
    public boolean addRolesToUser(int userId, List<String> roles) {
        for (String role : roles) {
            rolesRepository.addRoleToUser(userId, role);
        }
        return true;
    }
}
