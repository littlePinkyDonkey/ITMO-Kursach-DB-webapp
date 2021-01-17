package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.RecordingActorsPositions;

import javax.persistence.*;

@Entity(name = "recording_actors")
public class RecordingActor {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Transient
    private RecordingActorsPositions recordingActorsPosition;

    @Column(name = "POSITION")
    private String actorValue;

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getMainWorkerId() {
        return mainWorkerId;
    }
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public RecordingActorsPositions getRecordingActorsPosition() {
        return recordingActorsPosition;
    }
    public void setRecordingActorsPosition(RecordingActorsPositions recordingActorsPosition) {
        this.recordingActorsPosition = recordingActorsPosition;
    }

    @PrePersist
    public void prePersist() {
        if (recordingActorsPosition != null)
            this.actorValue = recordingActorsPosition.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (actorValue != null)
            this.recordingActorsPosition = RecordingActorsPositions.of(actorValue);
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id  =%d", super.toString(), workerId, mainWorkerId);
    }
}
