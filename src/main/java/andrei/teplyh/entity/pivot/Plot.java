package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.enums.PlotTypes;
import andrei.teplyh.entity.processes.PlotProcess;

import javax.persistence.*;

@Entity(name = "plot")
public class Plot {
    @Id
    @Column(name = "PLOT_ID")
    private int plotId;

    @ManyToOne
    @JoinColumn(name = "PLOT_PROCESS")
    private PlotProcess plotProcess;

    @Column(name = "PLOT_NAME")
    private String plotName;

    @Column(name = "PAGES_NUMBER")
    private int pagesNumber;

    @Transient
    private PlotTypes plotType;

    @Column(name = "PLOT_TYPE")
    private String plotValue;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getPlotId() {
        return plotId;
    }
    public void setPlotId(int plotId) {
        this.plotId = plotId;
    }

    public PlotProcess getPlotProcess() {
        return plotProcess;
    }
    public void setPlotProcess(PlotProcess plotProcess) {
        this.plotProcess = plotProcess;
    }

    public String getPlotName() {
        return plotName;
    }
    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }
    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public PlotTypes getPlotType() {
        return plotType;
    }
    public void setPlotType(PlotTypes plotType) {
        this.plotType = plotType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        if (plotType != null)
            this.plotValue = plotType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (plotValue != null)
            this.plotType = PlotTypes.of(plotValue);
    }
}
