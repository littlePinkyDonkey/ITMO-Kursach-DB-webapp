package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.EffectLevels;

import javax.persistence.*;

@Entity(name = "adding_effect_process")
public class AddingEffectProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private EffectLevels effectLevel;

    @Column(name = "EFFECT_LEVEL")
    private String effectValue;

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

    public EffectLevels getEffectLevel() {
        return effectLevel;
    }
    public void setEffectLevel(EffectLevels effectLevel) {
        this.effectLevel = effectLevel;
    }

    @PrePersist
    public void prePersist() {
        if (effectLevel != null)
            this.effectValue = effectLevel.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (effectValue != null)
            this.effectLevel = EffectLevels.of(effectValue);
    }
}
