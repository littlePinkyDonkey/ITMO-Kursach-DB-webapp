package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.AudioSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioSpecialistRepository extends JpaRepository<AudioSpecialist, Integer> {
    @Procedure("add_audio_specialist")
    int addAudioSpecialist(String name, String secondName, String gender, int age, String placeOfBirth);

    @Procedure("add_existing_audio_specialist")
    int addExistingAudioSpecialist(int mainWorkerId);

    @Procedure("delete_audio_specialist")
    boolean deleteAudioSpecialist(int mainWorkerId);

    @Procedure("associate_audio_specialist_and_process")
    boolean associateAudioSpecialistAndProcess(int workerId, int processId);
}
