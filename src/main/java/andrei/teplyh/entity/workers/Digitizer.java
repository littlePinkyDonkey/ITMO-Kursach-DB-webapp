package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.DigitizationProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "digitizers")
public class Digitizer {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @ManyToMany
    @JoinTable(
            name = "digitizers_digitization_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<DigitizationProcess> processes = new ArrayList<>();

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

    public List<DigitizationProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<DigitizationProcess> processes) {
        this.processes = processes;
    }
}
