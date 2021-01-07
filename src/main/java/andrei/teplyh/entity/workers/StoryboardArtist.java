package andrei.teplyh.entity.workers;

import javax.persistence.*;

@Entity(name = "storyboard_artists")
public class StoryboardArtist extends Worker {
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    public StoryboardArtist() {}
    public StoryboardArtist(long workerId, long mainWorkerId) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
    }

    @Override
    public String toString() {
        return String.format("%s | worker_id = %d | main_w_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
