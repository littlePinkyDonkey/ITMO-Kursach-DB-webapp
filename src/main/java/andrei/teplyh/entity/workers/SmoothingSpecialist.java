package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "smoothing_specialist")
public class SmoothingSpecialist {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public SmoothingSpecialist() {
    }
    public SmoothingSpecialist(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }
}
