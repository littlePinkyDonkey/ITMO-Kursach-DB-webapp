package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.BattleDescriptionProcess;
import andrei.teplyh.entity.processes.PlotProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "screenwriters")
public class Screenwriter {
    @Id
    @Column(name = "WORKER_ID")
    private int workerId;

    @OneToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

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

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
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
}
