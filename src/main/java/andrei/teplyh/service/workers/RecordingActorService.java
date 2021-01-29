package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.RecordingActor;

import java.util.List;

public interface RecordingActorService {
    List<RecordingActor> findAll();

    int addRecordingActor(String name, String secondName, String gender, String placeOfBirth,
                          String position);

    int addExistingRecordingActor(int mainWorkerId, String position);

    boolean deleteRecordingActor(int mainWorkerId);

    boolean associateRecorderAndProcess(int workerId, int processId);
}
