package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.StoryboardProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "storyboard_artists")
public class StoryboardArtist {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @ManyToMany
    @JoinTable(
            name = "artist_storyboard_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<StoryboardProcess> processes = new ArrayList<>();

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
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
}
