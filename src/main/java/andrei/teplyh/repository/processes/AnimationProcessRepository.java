package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AnimationProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AnimationProcessRepository extends JpaRepository<AnimationProcess, Integer> {
    @Procedure("create_animation_process")
    boolean createAnimationProcess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                   int frameRate, String animationTechnology);

    @Procedure("create_existing_animation_process")
    boolean createExistingAnimationProcess(int mainProcessId, int frameRate, String animationTechnology);

    @Procedure("delete_animation_process")
    boolean deleteAnimationProcess(int mainProcessId);
}
