package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.VoiceActingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface VoiceActingProcessRepository extends JpaRepository<VoiceActingProcess, Integer> {
    @Procedure("create_voice_acting_process")
    boolean createVoiceActingProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                     String voiceActingType);

    @Procedure("create_existing_voice_acting_process")
    boolean createExistingVoiceActingProcess(int mainProcessId, String voiceActingType);

    @Procedure("delete_voice_acting_process")
    boolean deleteVoiceActingProcess(int mainProcessId);

    @Procedure("associate_recorder_and_process")
    boolean associateRecorderAndProcess(int workerId, int processId);
}
