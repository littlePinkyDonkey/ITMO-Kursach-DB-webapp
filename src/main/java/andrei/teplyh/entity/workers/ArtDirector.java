package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.RevisionsProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "art_director")
public class ArtDirector extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @ManyToMany
    @JoinTable(
            name = "art_director_revision_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<RevisionsProcess> processes = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public List<RevisionsProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<RevisionsProcess> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
