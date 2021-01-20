package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.DigitizationTypes;
import andrei.teplyh.entity.workers.Digitizer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "digitization_process")
public class DigitizationProcess {
    @Id
    @Column(name = "PROCESS_ID")
    private int processId;

    @OneToOne
    @JoinColumn(name = "MAIN_PROCESS_ID")
    private Process process;

    @Column(name = "SKETCHES_NUMBER")
    private int sketchesNumber;

    @Transient
    private DigitizationTypes digitizationType;

    @Column(name = "DIGITIZATION_TYPE")
    private String digitizationValue;

    @ManyToMany
    @JoinTable(
            name = "digitizers_digitization_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Digitizer> workers = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getSketchesNumber() {
        return sketchesNumber;
    }
    public void setSketchesNumber(int sketchesNumber) {
        this.sketchesNumber = sketchesNumber;
    }

    public DigitizationTypes getDigitizationType() {
        return digitizationType;
    }
    public void setDigitizationType(DigitizationTypes digitizationType) {
        this.digitizationType = digitizationType;
    }

    public List<Digitizer> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Digitizer> workers) {
        this.workers = workers;
    }

    @PrePersist
    public void prePersist() {
        if (digitizationType != null)
            this.digitizationValue = digitizationType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (digitizationValue != null)
            this.digitizationType = DigitizationTypes.of(digitizationValue);
    }
}
