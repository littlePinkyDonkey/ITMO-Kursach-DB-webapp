package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.ColoringProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ColoringProcessRepository extends JpaRepository<ColoringProcess, Integer> {
    @Procedure("create_coloring_process")
    boolean createColoringProcess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                  String coloringType);

    @Procedure("create_existing_coloring_process")
    boolean createExistingColoringProcess(int mainProcessId, String coloringType);

    @Procedure("delete_coloring_process")
    boolean deleteColoringProcess(int mainProcessId);
}
