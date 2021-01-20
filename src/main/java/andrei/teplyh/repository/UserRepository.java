package andrei.teplyh.repository;

import andrei.teplyh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //TODO
    @Procedure("add_user")
    boolean addUser();

    @Procedure("delete_user")
    boolean deleteUser(int mainWorkerId);

    @Procedure("add_role_to_user")
    boolean addRoleToUser(int userId, String roleValue);

    @Procedure("delete_users_role")
    boolean deleteUsersRole(String roleValue);

    User getUserByLogin(String login);
}
