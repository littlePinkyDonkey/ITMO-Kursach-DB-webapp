package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.PlotProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PlotProcessRepository extends JpaRepository<PlotProcess, Integer> {
    @Procedure("create_plot_process")
    boolean createPlotProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_plot_process")
    boolean createExistingPlotProcess(int mainProcessId);

    @Procedure("delete_plot_process")
    boolean deletePlotProcess(int mainProcessId);
}
