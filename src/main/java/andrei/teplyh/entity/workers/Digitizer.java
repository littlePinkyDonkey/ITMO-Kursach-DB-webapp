package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.DigitizationProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "digitizers")
public class Digitizer extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

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

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public List<DigitizationProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<DigitizationProcess> processes) {
        this.processes = processes;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id  =%d", super.toString(), workerId, mainWorkerId);
    }
}
