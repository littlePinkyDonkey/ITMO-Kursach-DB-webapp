package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.CharacterDrawingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CharacterDrawingProcessRepository extends JpaRepository<CharacterDrawingProcess, Integer> {
    @Procedure("create_character_drawing_process")
    boolean createCharacterDrawingProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_character_drawing_process")
    boolean createExistingCharacterDrawingProcess(int mainProcessId);

    @Procedure("delete_character_drawing_process")
    boolean deleteCharacterDrawingProcess(int mainProcessId);

    @Procedure("associate_artist_and_character_drawing_process")
    boolean associateArtistAndCharacterDrawingProcess(int workerId, int processId);
}
