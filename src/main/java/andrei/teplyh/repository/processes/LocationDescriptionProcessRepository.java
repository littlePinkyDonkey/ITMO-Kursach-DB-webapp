package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.LocationDescriptionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface LocationDescriptionProcessRepository extends JpaRepository<LocationDescriptionProcess, Integer> {
    @Procedure("create_location_description_process")
    boolean createLocationDescriptionProcess(int duration, Date deadlineDate, String description, String status, Date startDate);

    @Procedure("create_existing_location_description_process")
    boolean createExistingLocationDescriptionProcess(int mainProcessId);

    @Procedure("delete_location_description_process")
    boolean deleteLocationDescriptionProcess(int mainProcessId);
}
