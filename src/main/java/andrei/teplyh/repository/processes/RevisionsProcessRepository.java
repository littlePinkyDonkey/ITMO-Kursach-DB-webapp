package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.RevisionsProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface RevisionsProcessRepository extends JpaRepository<RevisionsProcess, Integer> {
    @Procedure("create_revision_process")
    int createRevisionProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                  String revisionType);

    @Procedure("create_existing_revision_process")
    int createExistingRevisionProcess(int mainProcessId, String revisionType);

    @Procedure("delete_revisions_process")
    boolean deleteRevisionsProcess(int mainProcessId);

    @Procedure("associate_art_director_and_process")
    boolean associateArtDirectorAndProcess(int workerId, int processId);

    @Procedure("associate_revision_and_storyboarding")
    boolean associateRevisionAndStoryboarding(int revisionId, int processId);

    @Procedure("associate_revision_and_adding_sound")
    boolean associateRevisionAndDddingSound(int revisionId, int processId);

    @Procedure("associate_revision_and_smoothing")
    boolean associateRevisionAndSmoothing(int revisionId, int processId);

    @Procedure("associate_revision_and_adding_effects")
    boolean associateRevisionAndAddingEffects(int revisionId, int processId);

    @Procedure("associate_revision_and_animation")
    boolean associateRevisionAndAnimation(int revisionId, int processId);

    @Procedure("associate_revision_and_coloring")
    boolean associateRevisionAndColoring(int revisionId, int processId);
}
