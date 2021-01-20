package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.LocationDrawingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface LocationDrawingProcessRepository extends JpaRepository<LocationDrawingProcess, Integer> {
    @Procedure("create_location_drawing_process")
    int createLocationDrawingProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_location_drawing_process")
    int createExistingLocationDrawingProcess(int mainProcessId);

    @Procedure("delete_location_drawing_process")
    boolean deleteLocationDrawingProcess(int mainProcessId);

    @Procedure("associate_artist_and_location_drawing_process")
    boolean associateArtistAndLocationDrawingProcess(int workerId, int processId);
}
