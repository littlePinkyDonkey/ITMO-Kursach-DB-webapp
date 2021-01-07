package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.RecordingActorsPositions;

import javax.persistence.*;

@Entity(name = "recording_actors")
public class RecordingActor extends Worker {
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    @Transient
    private RecordingActorsPositions recordingActorsPosition;

    @Column(name = "POSITION")
    private String actorValue;

    public RecordingActor() {
    }
    public RecordingActor(long workerId, long mainWorkerId, RecordingActorsPositions recordingActorsPosition, String actorValue) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
        this.recordingActorsPosition = recordingActorsPosition;
        this.actorValue = actorValue;
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
