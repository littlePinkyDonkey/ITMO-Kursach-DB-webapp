package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AnimationProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface AnimationProcessRepository extends JpaRepository<AnimationProcess, Integer> {
    @Procedure("create_animation_process")
    boolean createAnimationProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                   int frameRate, String animationTechnology);

    @Procedure("create_existing_animation_process")
    boolean createExistingAnimationProcess(int mainProcessId, int frameRate, String animationTechnology);

    @Procedure("delete_animation_process")
    boolean deleteAnimationProcess(int mainProcessId);

    @Procedure("associate_artist_and_animation_process")
    boolean associateArtistAndAnimationProcess(int workerId, int processId);

    @Procedure("associate_revision_and_animation")
    boolean associateRevisionAndAnimation(int revisionId, int processId);
}
