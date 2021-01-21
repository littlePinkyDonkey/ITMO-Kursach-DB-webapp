package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.AddingSoundProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "audio_specialist")
public class AudioSpecialist {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @ManyToMany
    @JoinTable(
            name = "audio_adding_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AddingSoundProcess> processes = new ArrayList<>();

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

    public List<AddingSoundProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<AddingSoundProcess> processes) {
        this.processes = processes;
    }
}
