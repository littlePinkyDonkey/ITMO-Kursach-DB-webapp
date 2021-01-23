package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AddingSoundProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface AddingSoundProcessRepository extends JpaRepository<AddingSoundProcess, Integer> {
    @Procedure("create_adding_sound_effect_process")
    int createAddingSoundEffectProcess(int productId, int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                           String soundType);

    @Procedure("create_existing_adding_sound_effect_process")
    int createExistingAddingSoundEffectProcess(int mainProcessId, String soundType);

    @Procedure("delete_adding_sound_process")
    boolean deleteAddingSoundProcess(int mainProcessId);

    @Procedure("associate_audio_specialist_and_process")
    boolean associateAudioSpecialistAndProcess(int workerId, int processId);

    @Procedure("associate_revision_and_adding_sound")
    boolean associateRevisionAndDddingSound(int revisionId, int processId);
}
