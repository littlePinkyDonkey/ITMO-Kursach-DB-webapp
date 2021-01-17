package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.VoiceActingTypes;
import andrei.teplyh.entity.pivot.Character;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "voiceActingProcess")
    private List<Character> characters = new ArrayList<>();

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

    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
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
