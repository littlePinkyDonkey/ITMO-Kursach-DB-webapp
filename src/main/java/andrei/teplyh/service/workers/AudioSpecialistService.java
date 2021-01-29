package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.AudioSpecialist;

import java.util.List;

public interface AudioSpecialistService {
    List<AudioSpecialist> findAll();

    int addAudioSpecialist(String name, String secondName, String gender, String placeOfBirth);

    int addExistingAudioSpecialist(int mainWorkerId);

    boolean deleteAudioSpecialist(int mainWorkerId);

    boolean associateAudioSpecialistAndProcess(int workerId, int processId);
}
