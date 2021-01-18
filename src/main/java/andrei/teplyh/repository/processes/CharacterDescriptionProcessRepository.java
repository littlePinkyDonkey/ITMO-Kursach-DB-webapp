package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.CharacterDescriptionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CharacterDescriptionProcessRepository extends JpaRepository<CharacterDescriptionProcess, Integer> {
    @Procedure("create_character_description_process")
    boolean createCharacterDescriptionProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_character_description_process")
    boolean createExistingCharacterDescriptionProcess(int mainProcessId);

    @Procedure("delete_character_description_process")
    boolean deleteCharacterDescriptionProcess(int mainProcessId);
}
