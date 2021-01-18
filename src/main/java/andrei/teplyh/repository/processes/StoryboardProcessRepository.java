package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.StoryboardProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface StoryboardProcessRepository extends JpaRepository<StoryboardProcess, Integer> {
    @Procedure("create_storyboard_process")
    boolean createStoryboardProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                    int frameNumber);

    @Procedure("create_existing_storyboard_process")
    boolean createExistingStoryboardProcess(int mainProcessId, int frameNumber);

    @Procedure("delete_storyboard_process")
    boolean deleteStoryboardProcess(int mainProcessId);

    @Procedure("associate_storyboarder_and_process")
    boolean associateStoryboarderAndProcess(int workerId, int processId);

    @Procedure("associate_revision_and_storyboarding")
    boolean associateRevisionAndStoryboarding(int revisionId, int processId);
}
