package andrei.teplyh.service;

import andrei.teplyh.entity.User;

public interface PasswordHashService {
    void createPassword(User user);
    boolean checkAccess(User user);
}
