package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.VoiceActingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VoiceActingProcessRepository extends JpaRepository<VoiceActingProcess, Integer> {
    @Procedure("create_voice_acting_process")
    boolean createVoiceActingProcess(int duration, Date deadlineDate, String description, String status, Date startDate,
                                     String voiceActingType);

    @Procedure("create_existing_voice_acting_process")
    boolean createExistingVoiceActingProcess(int mainProcessId, String voiceActingType);

    @Procedure("delete_voice_acting_process")
    boolean deleteVoiceActingProcess(int mainProcessId);
}
