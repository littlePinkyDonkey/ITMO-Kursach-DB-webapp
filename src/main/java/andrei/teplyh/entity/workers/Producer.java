package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ProducerRoles;
import andrei.teplyh.entity.processes.AdvertisingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "producers")
public class Producer extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Transient
    private ProducerRoles producerRole;

    @Column(name = "ROLE")
    private String roleValue;

    @ManyToMany
    @JoinTable(
            name = "producer_advertising_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AdvertisingProcess> processes = new ArrayList<>();

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

    public ProducerRoles getProducerRole() {
        return producerRole;
    }
    public void setProducerRole(ProducerRoles producerRole) {
        this.producerRole = producerRole;
    }

    public List<AdvertisingProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<AdvertisingProcess> processes) {
        this.processes = processes;
    }

    @PrePersist
    public void prePersist() {
        if (producerRole != null)
            this.roleValue = producerRole.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (roleValue != null)
            this.producerRole = ProducerRoles.of(roleValue);
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id  =%d", super.toString(), workerId, mainWorkerId);
    }
}
