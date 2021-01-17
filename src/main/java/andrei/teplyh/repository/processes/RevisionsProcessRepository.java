package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.RevisionsProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RevisionsProcessRepository extends JpaRepository<RevisionsProcess, Integer> {
    @Procedure("create_revision_process")
    boolean createRevisionProcess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                  String revisionType);

    @Procedure("create_existing_revision_process")
    boolean createExistingRevisionProcess(int mainProcessId, String revisionType);

    @Procedure("delete_revisions_process")
    boolean deleteRevisionsProcess(int mainProcessId);
}
