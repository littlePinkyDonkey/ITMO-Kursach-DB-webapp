package andrei.teplyh.entity;

import andrei.teplyh.entity.workers.Worker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @Column(name = "USER_ID")
    private int userId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "AVATAR_FILE_LINK")
    private String avatarFilePath;

    @Column(name = "LAST_LOG_OUT")
    private Date lastLogOut;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_VALUE")
    )
    private List<Role> roles = new ArrayList<>();

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarFilePath() {
        return avatarFilePath;
    }
    public void setAvatarFilePath(String avatarFilePath) {
        this.avatarFilePath = avatarFilePath;
    }

    public Date getLastLogOut() {
        return lastLogOut;
    }
    public void setLastLogOut(Date lastLogOut) {
        this.lastLogOut = lastLogOut;
    }

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format("userId = %d || password = %s || main_worker_id = %d || name = %s",
                userId, password, worker.getMainWorkerId(), worker.getName());
    }
}
