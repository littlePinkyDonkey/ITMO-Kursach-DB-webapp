package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.RecordingActorsPositions;
import andrei.teplyh.entity.processes.VoiceActingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "recording_actors")
public class RecordingActor {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @Transient
    private RecordingActorsPositions recordingActorsPosition;

    @Column(name = "POSITION")
    private String actorValue;

    @ManyToMany
    @JoinTable(
            name = "recorder_voice_acting_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<VoiceActingProcess> processes = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public RecordingActorsPositions getRecordingActorsPosition() {
        return recordingActorsPosition;
    }
    public void setRecordingActorsPosition(RecordingActorsPositions recordingActorsPosition) {
        this.recordingActorsPosition = recordingActorsPosition;
    }

    public List<VoiceActingProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<VoiceActingProcess> processes) {
        this.processes = processes;
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
}
