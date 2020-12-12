package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "digitizers")
public class Digitizer {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public Digitizer() {
    }
    public Digitizer(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }
}
