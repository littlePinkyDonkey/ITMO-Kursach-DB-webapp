package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.StoryboardProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "storyboard_artists")
public class StoryboardArtist extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @ManyToMany
    @JoinTable(
            name = "artist_storyboard_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<StoryboardProcess> processes = new ArrayList<>();

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

    public List<StoryboardProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<StoryboardProcess> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return String.format("%s || worker_id = %d || main_w_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
