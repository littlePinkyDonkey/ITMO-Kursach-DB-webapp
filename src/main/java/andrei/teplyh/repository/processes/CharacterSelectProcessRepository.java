package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.CharacterSelectProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CharacterSelectProcessRepository extends JpaRepository<CharacterSelectProcess, Integer> {
    @Procedure("create_character_select_process")
    int createCharacterSelectprocess(int productId, int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_character_select_process")
    int createExistingCharacterSelectprocess(int mainProcessId);

    @Procedure("delete_character_select_process")
    boolean deleteCharacterSelectProcess(int mainProcessId);

    @Procedure("associate_editor_and_process")
    boolean associateEditorAndProcess(int workerId, int processId);
}
