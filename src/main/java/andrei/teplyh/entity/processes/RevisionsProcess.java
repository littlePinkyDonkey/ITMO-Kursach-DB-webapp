package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.RevisionTypes;
import andrei.teplyh.entity.workers.ArtDirector;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "revisions_process")
public class RevisionsProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private RevisionTypes revisionType;

    @Column(name = "REVISION_TYPE")
    private String revisionValue;

    @ManyToMany
    @JoinTable(
            name = "art_director_revision_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<ArtDirector> workers = new ArrayList<>();

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

    public RevisionTypes getRevisionType() {
        return revisionType;
    }
    public void setRevisionType(RevisionTypes revisionType) {
        this.revisionType = revisionType;
    }

    public List<ArtDirector> getWorkers() {
        return workers;
    }
    public void setWorkers(List<ArtDirector> workers) {
        this.workers = workers;
    }

    @PrePersist
    public void prePersist() {
        if (revisionType != null)
            this.revisionValue = revisionType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (revisionValue != null)
            this.revisionType = RevisionTypes.of(revisionValue);
    }
}
