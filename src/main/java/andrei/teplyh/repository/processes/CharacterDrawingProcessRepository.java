package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.CharacterDrawingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CharacterDrawingProcessRepository extends JpaRepository<CharacterDrawingProcess, Integer> {
    @Procedure("create_character_drawing_process")
    boolean createCharacterDrawingProcess(int duration, Date deadlineDate, String description, String status, Date startDate);

    @Procedure("create_existing_character_drawing_process")
    boolean createExistingCharacterDrawingProcess(int mainProcessId);

    @Procedure("delete_character_drawing_process")
    boolean deleteCharacterDrawingProcess(int mainProcessId);
}
