package andrei.teplyh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class Role {
    @Id
    @Column(name = "ROLE_VALUE")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "ROLE_VALUE"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private List<User> users = new ArrayList<>();

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
