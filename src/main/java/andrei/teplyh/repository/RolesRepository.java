package andrei.teplyh.repository;

import andrei.teplyh.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {
    @Procedure("add_role")
    boolean addRole(String roleValue);

    boolean deleteRoleByRole(String role);

    @Procedure("add_role_to_user")
    boolean addRoleToUser(int userId, String roleValue);

    @Procedure("delete_users_role")
    boolean deleteUsersRole(String roleValue);

    Role getRoleByRole(String role);
}
