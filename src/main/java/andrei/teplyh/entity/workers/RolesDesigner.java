package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "roles_designers")
public class RolesDesigner extends Worker {
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public RolesDesigner() {
    }
    public RolesDesigner(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d", super.toString(), workerId);
    }
}
