package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.SoundTypes;
import andrei.teplyh.entity.workers.AudioSpecialist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "adding_sound_process")
public class AddingSoundProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private SoundTypes soundType;

    @Column(name = "SOUND_TYPE")
    private String soundValue;

    @ManyToMany
    @JoinTable(
            name = "audio_adding_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<AudioSpecialist> workers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_adding_sound",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "REVISION_ID")
    )
    private List<RevisionsProcess> revisionsProcesses = new ArrayList<>();

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

    public SoundTypes getSoundType() {
        return soundType;
    }
    public void setSoundType(SoundTypes soundType) {
        this.soundType = soundType;
    }

    public List<AudioSpecialist> getWorkers() {
        return workers;
    }
    public void setWorkers(List<AudioSpecialist> workers) {
        this.workers = workers;
    }

    public List<RevisionsProcess> getRevisionsProcesses() {
        return revisionsProcesses;
    }
    public void setRevisionsProcesses(List<RevisionsProcess> revisionsProcesses) {
        this.revisionsProcesses = revisionsProcesses;
    }

    @PrePersist
    public void prePersist() {
        if (soundType != null)
            this.soundValue = soundType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (soundValue != null)
            this.soundType = SoundTypes.of(soundValue);
    }
}
