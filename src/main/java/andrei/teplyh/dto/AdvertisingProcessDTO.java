package andrei.teplyh.dto;

import java.sql.Timestamp;

public class AdvertisingProcessDTO extends ProcessDTO {
    private int processId;
    private String insertionLocation;

    public AdvertisingProcessDTO(int mainProcessId,
                                 int duration,
                                 Timestamp deadlineDate,
                                 String description,
                                 String processStatus,
                                 Timestamp startDate,
                                 String insertionLocation) {
        super(mainProcessId, duration, deadlineDate, description, processStatus, startDate);
        this.insertionLocation = insertionLocation;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getInsertionLocation() {
        return insertionLocation;
    }

    public void setInsertionLocation(String insertionLocation) {
        this.insertionLocation = insertionLocation;
    }
}
