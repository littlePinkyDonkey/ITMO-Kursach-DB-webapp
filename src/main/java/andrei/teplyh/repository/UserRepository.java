package andrei.teplyh.repository;

import andrei.teplyh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Procedure("add_user")
    boolean addUser(int mainWorkerId, String login, String password, String salt, String email, Date lastLogOut);

    @Procedure("delete_user")
    boolean deleteUser(int mainWorkerId);

    @Procedure("add_role_to_user")
    boolean addRoleToUser(int userId, String roleValue);

    @Procedure("delete_users_role")
    boolean deleteUsersRole(String roleValue);

    User getUserByLogin(String login);
}
