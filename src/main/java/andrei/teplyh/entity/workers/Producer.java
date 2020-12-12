package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ProducerRoles;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "producers")
public class Producer {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    @Transient
    private ProducerRoles producerRole;

    @Column(name = "ROLE")
    private String roleValue;

    public Producer() {
    }
    public Producer(long workerId, long mainWorkerId, ProducerRoles producerRole, String roleValue) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
        this.producerRole = producerRole;
        this.roleValue = roleValue;
    }

    @PrePersist
    public void prePersist() {
        if (producerRole != null)
            this.roleValue = producerRole.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (roleValue != null)
            this.producerRole = ProducerRoles.of(roleValue);
    }
}
