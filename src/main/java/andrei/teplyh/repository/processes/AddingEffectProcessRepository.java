package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.AddingEffectProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface AddingEffectProcessRepository extends JpaRepository<AddingEffectProcess, Integer> {
    @Procedure("create_adding_effect_process")
    int createAddingEffectProcess(int productId, int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate,
                                      String effectLevel);

    @Procedure("create_existing_adding_effect_process")
    int createExistingAddingEffectProcess(int mainProcessId, String effectLevel);

    @Procedure("delete_adding_effect_process")
    boolean deleteAddingEffectProcess(int mainProcessId);

    @Procedure("associate_artist_and_effects_process")
    boolean associateArtistAndEffectsProcess(int workerId, int processId);

    @Procedure("associate_revision_and_adding_effects")
    boolean associateRevisionAndAddingEffects(int revisionId, int processId);
}
