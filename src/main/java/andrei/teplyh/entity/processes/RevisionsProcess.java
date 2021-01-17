package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.RevisionTypes;

import javax.persistence.*;

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
