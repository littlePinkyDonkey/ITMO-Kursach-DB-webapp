package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.DigitizationTypes;

import javax.persistence.*;

@Entity(name = "digitization_process")
public class DigitizationProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "SKETCHES_NUMBER")
    private int sketchesNumber;

    @Transient
    private DigitizationTypes digitizationType;

    @Column(name = "DIGITIZATION_TYPE")
    private String digitizationValue;

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    @Override
    public int getMainProcessId() {
        return mainProcessId;
    }
    @Override
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
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
