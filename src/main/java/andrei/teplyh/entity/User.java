package andrei.teplyh.entity;

import andrei.teplyh.entity.workers.Worker;

import javax.persistence.*;

@Entity(name = "users")
public class User {
    @Id
    @Column(name = "USER_ID")
    private long userId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @Column(name = "SALT")
    private String salt;

    @Transient
    private String password;

    @Column(name = "USER_PASSWORD")
    private String hash;

    public User() {
    }
    public User(long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return String.format("userId = %d || salt = %s || password = %s || main_worker_id = %d || name = %s",
                userId, salt, hash, worker.getMainWorkerId(), worker.getName());
    }
}
