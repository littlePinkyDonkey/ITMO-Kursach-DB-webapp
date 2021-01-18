package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.AddingSoundProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "audio_specialist")
public class AudioSpecialist extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

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

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public List<AddingSoundProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<AddingSoundProcess> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id  =%d", super.toString(), workerId, mainWorkerId);
    }
}
