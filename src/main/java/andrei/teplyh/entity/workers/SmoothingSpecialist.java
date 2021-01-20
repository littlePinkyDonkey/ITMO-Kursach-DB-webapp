package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.SmoothingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "smoothing_specialist")
public class SmoothingSpecialist {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @ManyToMany
    @JoinTable(
            name = "smoother_smoothing_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<SmoothingProcess> processes = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<SmoothingProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<SmoothingProcess> processes) {
        this.processes = processes;
    }
}
