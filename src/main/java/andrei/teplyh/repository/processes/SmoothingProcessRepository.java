package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.SmoothingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface SmoothingProcessRepository extends JpaRepository<SmoothingProcess, Integer> {
    @Procedure("create_smoothing_process")
    boolean createSmoothingProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_smoothing_process")
    boolean createExistingSmoothingProcess(int mainProcessId);

    @Procedure("delete_smoothing_process")
    boolean deleteSmoothingProcess(int mainProcessId);

    @Procedure("associate_smoother_and_process")
    boolean associateSmootherAndProcess(int workerId, int processId);
}
