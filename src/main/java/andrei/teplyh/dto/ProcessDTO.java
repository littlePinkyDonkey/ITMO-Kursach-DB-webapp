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
}
