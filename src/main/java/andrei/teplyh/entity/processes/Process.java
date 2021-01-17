package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.ProcessStatuses;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "processes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Process {
    @Id
    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "DEADLINE_DATE")
    private Date deadlineDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private ProcessStatuses status;

    @Column(name = "STATUS")
    private String processStatus;

    @Column(name = "START_DATE")
    private Date startDate;

    public int getMainProcessId() {
        return mainProcessId;
    }

    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

    @PrePersist
    public void prePersist() {
        if (status != null)
            this.processStatus = status.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (processStatus != null)
            this.status = ProcessStatuses.of(processStatus);
    }

    @Override
    public String toString() {
        return "Process{" +
                "mainProcessId=" + mainProcessId +
                ", duration=" + duration +
                ", deadlineDate=" + deadlineDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", processStatus='" + processStatus + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
