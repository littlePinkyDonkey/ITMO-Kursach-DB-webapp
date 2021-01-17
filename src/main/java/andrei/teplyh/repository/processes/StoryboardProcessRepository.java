package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.StoryboardProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StoryboardProcessRepository extends JpaRepository<StoryboardProcess, Integer> {
    @Procedure("create_storyboard_process")
    boolean createStoryboardprocess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                    int frameNumber);

    @Procedure("create_existing_storyboard_process")
    boolean createExistingStoryboardProcess(int mainProcessId, int frameNumber);

    @Procedure("delete_storyboard_process")
    boolean deleteStoryboardProcess(int mainProcessId);
}
