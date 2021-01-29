package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.RecordingActor;
import andrei.teplyh.repository.workers.RecordingActorRepository;
import andrei.teplyh.service.workers.RecordingActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordingActorServiceImpl implements RecordingActorService {
    private final RecordingActorRepository recordingActorRepository;

    @Autowired
    public RecordingActorServiceImpl(RecordingActorRepository recordingActorRepository) {
        this.recordingActorRepository = recordingActorRepository;
    }

    @Override
    public List<RecordingActor> findAll() {
        return null;
    }

    @Override
    public int addRecordingActor(String name, String secondName, String gender, String placeOfBirth, String position) {
        return 0;
    }

    @Override
    public int addExistingRecordingActor(int mainWorkerId, String position) {
        return recordingActorRepository.addExistingRecordingActor(mainWorkerId, position);
    }

    @Override
    public boolean deleteRecordingActor(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateRecorderAndProcess(int workerId, int processId) {
        return false;
    }
}
