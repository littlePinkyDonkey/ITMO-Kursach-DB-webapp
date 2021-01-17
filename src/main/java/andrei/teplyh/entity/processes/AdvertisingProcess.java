package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.InsertionLocations;

import javax.persistence.*;

@Entity(name = "advertising_process")
public class AdvertisingProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private InsertionLocations location;

    @Column(name = "INSERTION_LOCATION")
    private String insertionLocation;

    @Override
    public int getMainProcessId() {
        return mainProcessId;
    }
    @Override
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

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

    @Override
    public String toString() {
        return String.format("%s || process_id = %d || ins_loc = %s || main_p_id = %d",
                super.toString(), processId, insertionLocation, mainProcessId);
    }
}
