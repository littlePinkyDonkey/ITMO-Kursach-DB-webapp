package andrei.teplyh.entity.workers;

import javax.persistence.*;

@Entity(name = "art_director")
public class ArtDirector {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public ArtDirector() {
    }
    public ArtDirector(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }
}
