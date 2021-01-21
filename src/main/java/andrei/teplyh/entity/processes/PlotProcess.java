package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.pivot.Plot;
import andrei.teplyh.entity.workers.Regisseur;
import andrei.teplyh.entity.workers.Screenwriter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "plot_process")
public class PlotProcess {
    @Id
    @Column(name = "PROCESS_ID")
    private int processId;

    @OneToOne
    @JoinColumn(name = "MAIN_PROCESS_ID")
    private Process process;

    @OneToMany(mappedBy = "plotProcess")
    private List<Plot> plots = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "regisseurs_plot_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Regisseur> regisseurs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "screenwriter_plot_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Screenwriter> screenwriters = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public List<Plot> getPlots() {
        return plots;
    }
    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }

    public List<Regisseur> getRegisseurs() {
        return regisseurs;
    }
    public void setRegisseurs(List<Regisseur> regisseurs) {
        this.regisseurs = regisseurs;
    }

    public List<Screenwriter> getScreenwriters() {
        return screenwriters;
    }
    public void setScreenwriters(List<Screenwriter> screenwriters) {
        this.screenwriters = screenwriters;
    }
}
