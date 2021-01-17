package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.VoiceActingTypes;

import javax.persistence.*;

@Entity(name = "voice_acting_process")
public class VoiceActingProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private VoiceActingTypes voiceActingType;

    @Column(name = "VOICE_ACTING_TYPE")
    private String voiceActingValue;

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

    public VoiceActingTypes getVoiceActingType() {
        return voiceActingType;
    }
    public void setVoiceActingType(VoiceActingTypes voiceActingType) {
        this.voiceActingType = voiceActingType;
    }

    @PrePersist
    public void prePersist() {
        if (voiceActingType != null)
            this.voiceActingValue = voiceActingType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (voiceActingValue != null)
            this.voiceActingType = VoiceActingTypes.of(voiceActingValue);
    }
}
