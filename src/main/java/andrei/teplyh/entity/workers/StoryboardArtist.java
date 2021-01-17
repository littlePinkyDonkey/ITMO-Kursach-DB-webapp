package andrei.teplyh.entity.workers;

import javax.persistence.*;

@Entity(name = "storyboard_artists")
public class StoryboardArtist extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }
    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return String.format("%s || worker_id = %d || main_w_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
