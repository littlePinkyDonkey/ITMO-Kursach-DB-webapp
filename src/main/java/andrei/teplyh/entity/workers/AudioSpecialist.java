package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "audio_specialist")
public class AudioSpecialist {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public AudioSpecialist() {
    }
    public AudioSpecialist(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }
}
