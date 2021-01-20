package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ProducerRoles;
import andrei.teplyh.entity.processes.AdvertisingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "producers")
public class Producer {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

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
}
