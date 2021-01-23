package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    @Procedure("create_process")
    int createProcess(int productId, int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("delete_process")
    boolean deleteProcess(int mainProcessId);

    @Procedure("associate_artifact_and_process")
    boolean associateArtifactAndProcess(int artifactId, int mainProcessId);
}
