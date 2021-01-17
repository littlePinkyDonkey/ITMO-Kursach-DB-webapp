package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    @Procedure("create_process")
    boolean createProcess(int duration, Date deadlineDate, String description, String status, Date startDate);

    @Procedure("delete_process")
    boolean deleteProcess(int mainProcessId);
}
