package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.pivot.Battle;
import andrei.teplyh.entity.workers.Artist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "battle_drawing_process")
public class BattleDrawingProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @OneToMany(mappedBy = "battleDrawingProcess")
    private List<Battle> battles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_battle_drawing_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Artist> workers = new ArrayList<>();

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

    public List<Artist> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Artist> workers) {
        this.workers = workers;
    }
}
