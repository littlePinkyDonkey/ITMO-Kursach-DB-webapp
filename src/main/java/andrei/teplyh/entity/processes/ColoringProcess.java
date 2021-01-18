package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.ColoringTypes;
import andrei.teplyh.entity.workers.Artist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "coloring_process")
public class ColoringProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private ColoringTypes coloringType;

    @Column(name = "COLORING_TYPE")
    private String coloringValue;

    @ManyToMany
    @JoinTable(
            name = "artist_coloring_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Artist> workers = new ArrayList<>();

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

    public ColoringTypes getColoringType() {
        return coloringType;
    }
    public void setColoringType(ColoringTypes coloringType) {
        this.coloringType = coloringType;
    }

    public List<Artist> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Artist> workers) {
        this.workers = workers;
    }

    @PrePersist
    public void prePersist() {
        if (coloringType != null)
            this.coloringValue = coloringType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (coloringValue != null)
            this.coloringType = ColoringTypes.of(coloringValue);
    }
}
