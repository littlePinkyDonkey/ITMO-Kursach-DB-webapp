package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.AudioSpecialist;
import andrei.teplyh.repository.workers.AudioSpecialistRepository;
import andrei.teplyh.service.workers.AudioSpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioSpecialistServiceImpl implements AudioSpecialistService {
    private final AudioSpecialistRepository audioSpecialistRepository;

    @Autowired
    public AudioSpecialistServiceImpl(AudioSpecialistRepository audioSpecialistRepository) {
        this.audioSpecialistRepository = audioSpecialistRepository;
    }

    @Override
    public List<AudioSpecialist> findAll() {
        return null;
    }

    @Override
    public int addAudioSpecialist(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingAudioSpecialist(int mainWorkerId) {
        return audioSpecialistRepository.addExistingAudioSpecialist(mainWorkerId);
    }

    @Override
    public boolean deleteAudioSpecialist(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateAudioSpecialistAndProcess(int workerId, int processId) {
        return false;
    }
}
