package andrei.teplyh.dto;

import java.sql.Timestamp;

public class ProcessDTO {
    private int mainProcessId;
    private int duration;
    private Timestamp deadlineDate;
    private String description;
    private String processStatus;
    private Timestamp startDate;

    public ProcessDTO(
            int mainProcessId,
            int duration,
            Timestamp deadlineDate,
            String description,
            String processStatus,
            Timestamp startDate
    ) {
        this.mainProcessId = mainProcessId;
        this.duration = duration;
        this.deadlineDate = deadlineDate;
        this.description = description;
        this.processStatus = processStatus;
        this.startDate = startDate;
    }

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

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
}
