package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.RecordingActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingActorRepository extends JpaRepository<RecordingActor, Integer> {
    @Procedure("add_recording_actor")
    int addRecordingActor(String name, String secondName, String gender, int age, String placeOfBirth,
                              String position);

    @Procedure("add_existing_recording_actor")
    int addExistingRecordingActor(int mainWorkerId, String position);

    @Procedure("delete_recording_actor")
    boolean deleteRecordingActor(int mainWorkerId);

    @Procedure("associate_recorder_and_process")
    boolean associateRecorderAndProcess(int workerId, int processId);
}
