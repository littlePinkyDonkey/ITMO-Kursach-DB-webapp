package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.ColoringProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ColoringProcessRepository extends JpaRepository<ColoringProcess, Integer> {
    @Procedure("create_coloring_process")
    int createColoringProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                  String coloringType);

    @Procedure("create_existing_coloring_process")
    int createExistingColoringProcess(int mainProcessId, String coloringType);

    @Procedure("delete_coloring_process")
    boolean deleteColoringProcess(int mainProcessId);

    @Procedure("associate_artist_and_coloring_process")
    boolean associateArtistAndColoringProcess(int workerId, int processId);

    @Procedure("associate_revision_and_coloring")
    boolean associateRevisionAndColoring(int revisionId, int processId);
}
