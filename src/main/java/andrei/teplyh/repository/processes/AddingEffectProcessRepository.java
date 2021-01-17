package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AddingEffectProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AddingEffectProcessRepository extends JpaRepository<AddingEffectProcess, Integer> {
    @Procedure("create_adding_effect_process")
    boolean createAddingEffectProcess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                      String effectLevel);

    @Procedure("create_existing_adding_effect_process")
    boolean createExistingAddingEffectProcess(int mainProcessId, String effectLevel);

    @Procedure("delete_adding_effect_process")
    boolean deleteAddingEffectProcess(int mainProcessId);
}
