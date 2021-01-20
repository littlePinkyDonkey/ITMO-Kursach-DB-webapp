package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.PlotProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PlotProcessRepository extends JpaRepository<PlotProcess, Integer> {
    @Procedure("create_plot_process")
    int createPlotProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_plot_process")
    int createExistingPlotProcess(int mainProcessId);

    @Procedure("delete_plot_process")
    boolean deletePlotProcess(int mainProcessId);

    @Procedure("associate_regisseur_and_plot_process")
    boolean associateRegisseurAndPlotProcess(int workerId, int processId);

    @Procedure("associate_screenwriter_and_plot_process")
    boolean associateScreenwriterAndPlotProcess(int workerId, int processId);
}
