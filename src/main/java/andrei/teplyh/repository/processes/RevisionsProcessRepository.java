package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.RevisionsProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface RevisionsProcessRepository extends JpaRepository<RevisionsProcess, Integer> {
    @Procedure("create_revision_process")
    boolean createRevisionProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                  String revisionType);

    @Procedure("create_existing_revision_process")
    boolean createExistingRevisionProcess(int mainProcessId, String revisionType);

    @Procedure("delete_revisions_process")
    boolean deleteRevisionsProcess(int mainProcessId);

    @Procedure("associate_art_director_and_process")
    boolean associateArtDirectorAndProcess(int workerId, int processId);
}
