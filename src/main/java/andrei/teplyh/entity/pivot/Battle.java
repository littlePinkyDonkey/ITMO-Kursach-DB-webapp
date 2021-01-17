package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.processes.BattleDescriptionProcess;
import andrei.teplyh.entity.processes.BattleDrawingProcess;

import javax.persistence.*;

@Entity(name = "battle")
public class Battle {
    @Id
    @Column(name = "BATTLE_ID")
    private int battleId;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private BattleDescriptionProcess descriptionProcess;

    @ManyToOne
    @JoinColumn(name = "DRAWING_ID")
    private BattleDrawingProcess battleDrawingProcess;

    @Column(name = "BATTLE_NAME")
    private String name;

    @Column(name = "DURATION")
    private float duration;

    public int getBattleId() {
        return battleId;
    }
    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public BattleDescriptionProcess getDescriptionProcess() {
        return descriptionProcess;
    }
    public void setDescriptionProcess(BattleDescriptionProcess descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public BattleDrawingProcess getBattleDrawingProcess() {
        return battleDrawingProcess;
    }
    public void setBattleDrawingProcess(BattleDrawingProcess battleDrawingProcess) {
        this.battleDrawingProcess = battleDrawingProcess;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
}
