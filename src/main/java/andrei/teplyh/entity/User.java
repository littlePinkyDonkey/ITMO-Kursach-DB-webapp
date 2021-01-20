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

    @Column(name = "SALT")
    private String salt;

    @Transient
    private String password;

    @Column(name = "USER_PASSWORD")
    private String hash;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "LAST_LOG_OUT")
    private Date lastLogOut;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_VALUE")
    )
    private List<Role> roles = new ArrayList<>();

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
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
        return String.format("userId = %d || salt = %s || password = %s || main_worker_id = %d || name = %s",
                userId, salt, hash, worker.getMainWorkerId(), worker.getName());
    }
}
