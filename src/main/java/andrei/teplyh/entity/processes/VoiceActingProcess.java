package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.VoiceActingTypes;
import andrei.teplyh.entity.pivot.Character;
import andrei.teplyh.entity.workers.RecordingActor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "voice_acting_process")
public class VoiceActingProcess {
    @Id
    @Column(name = "PROCESS_ID")
    private int processId;

    @OneToOne
    @JoinColumn(name = "MAIN_PROCESS_ID")
    private Process process;

    @Transient
    private VoiceActingTypes voiceActingType;

    @Column(name = "VOICE_ACTING_TYPE")
    private String voiceActingValue;

    @OneToMany(mappedBy = "voiceActingProcess")
    private List<Character> characters = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "recorder_voice_acting_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<RecordingActor> workers = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
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

    public List<RecordingActor> getWorkers() {
        return workers;
    }
    public void setWorkers(List<RecordingActor> workers) {
        this.workers = workers;
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
