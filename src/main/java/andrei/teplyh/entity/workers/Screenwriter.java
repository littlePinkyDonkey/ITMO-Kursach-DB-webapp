package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.BattleDescriptionProcess;
import andrei.teplyh.entity.processes.PlotProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "screenwriters")
public class Screenwriter extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Column(name = "FILMS_NUMBER")
    private int filmsNumber;

    @ManyToMany
    @JoinTable(
            name = "screenwriter_battle_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<BattleDescriptionProcess> battleDescriptionProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "screenwriter_plot_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<PlotProcess> plotProcesses = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public int getFilmsNumber() {
        return filmsNumber;
    }
    public void setFilmsNumber(int filmsNumber) {
        this.filmsNumber = filmsNumber;
    }

    public List<BattleDescriptionProcess> getBattleDescriptionProcesses() {
        return battleDescriptionProcesses;
    }
    public void setBattleDescriptionProcesses(List<BattleDescriptionProcess> battleDescriptionProcesses) {
        this.battleDescriptionProcesses = battleDescriptionProcesses;
    }

    public List<PlotProcess> getPlotProcesses() {
        return plotProcesses;
    }
    public void setPlotProcesses(List<PlotProcess> plotProcesses) {
        this.plotProcesses = plotProcesses;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
