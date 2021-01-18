package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.ProcessStatuses;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp deadlineDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private ProcessStatuses status;

    @Column(name = "STATUS")
    private String processStatus;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    public int getMainProcessId() {
        return mainProcessId;
    }
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }
    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public ProcessStatuses getStatus() {
        return status;
    }
    public void setStatus(ProcessStatuses status) {
        this.status = status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
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
