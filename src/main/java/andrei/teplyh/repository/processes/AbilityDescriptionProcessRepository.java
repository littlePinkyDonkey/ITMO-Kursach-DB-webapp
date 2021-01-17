package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AbilityDescriptionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AbilityDescriptionProcessRepository extends JpaRepository<AbilityDescriptionProcess, Integer> {
    @Procedure("create_ability_description_process")
    boolean createAbilityDescriptionProcess(int duration, Date deadlineDate, String description, String status, Date startDate);

    @Procedure("create_existing_ability_description_process")
    boolean createExistingAbilityDescriptionProcess(int mainProcessId);

    @Procedure("delete_ability_description_process")
    boolean deleteAbilityDescriptionProcess(int mainProcessId);
}
