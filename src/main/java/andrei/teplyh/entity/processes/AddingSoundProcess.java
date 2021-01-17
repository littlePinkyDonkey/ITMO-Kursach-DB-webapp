package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.SoundTypes;

import javax.persistence.*;

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
