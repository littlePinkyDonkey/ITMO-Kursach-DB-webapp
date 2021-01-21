package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.InsertionLocations;
import andrei.teplyh.entity.workers.Producer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "advertising_process")
public class AdvertisingProcess {
    @Id
    @Column(name = "PROCESS_ID")
    private int processId;

    @OneToOne
    @JoinColumn(name = "MAIN_PROCESS_ID")
    private Process process;

    @Transient
    private InsertionLocations location;

    @Column(name = "INSERTION_LOCATION")
    private String insertionLocation;

    @ManyToMany
    @JoinTable(
            name = "producer_advertising_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Producer> producers = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public InsertionLocations getLocation() {
        return location;
    }
    public void setLocation(InsertionLocations location) {
        this.location = location;
    }

    public List<Producer> getProducers() {
        return producers;
    }
    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    @PrePersist
    public void prePersist() {
        if (location != null)
            this.insertionLocation = location.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (insertionLocation != null)
            this.location = InsertionLocations.of(insertionLocation);
    }
}
