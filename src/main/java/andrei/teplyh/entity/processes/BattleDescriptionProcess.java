package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.pivot.Battle;
import andrei.teplyh.entity.workers.Screenwriter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "battle_description_process")
public class BattleDescriptionProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @OneToMany(mappedBy = "descriptionProcess")
    private List<Battle> battles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "screenwriter_battle_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Screenwriter> workers = new ArrayList<>();

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

    public List<Battle> getBattles() {
        return battles;
    }
    public void setBattles(List<Battle> battles) {
        this.battles = battles;
    }

    public List<Screenwriter> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Screenwriter> workers) {
        this.workers = workers;
    }
}
