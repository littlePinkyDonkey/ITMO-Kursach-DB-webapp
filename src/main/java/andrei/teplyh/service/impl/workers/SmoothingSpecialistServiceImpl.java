package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.SmoothingSpecialist;
import andrei.teplyh.repository.workers.SmoothingSpecialistRepository;
import andrei.teplyh.service.workers.SmoothingSpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmoothingSpecialistServiceImpl implements SmoothingSpecialistService {
    private final SmoothingSpecialistRepository smoothingSpecialistRepository;

    @Autowired
    public SmoothingSpecialistServiceImpl(SmoothingSpecialistRepository smoothingSpecialistRepository) {
        this.smoothingSpecialistRepository = smoothingSpecialistRepository;
    }

    @Override
    public List<SmoothingSpecialist> findAll() {
        return null;
    }

    @Override
    public int addSmoothingSpecialist(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingSmoothingSpecialist(int mainWorkerId) {
        return smoothingSpecialistRepository.addExistingSmoothingSpecialist(mainWorkerId);
    }

    @Override
    public boolean deleteSmoothingSpecialist(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateSmootherAndProcess(int workerId, int processId) {
        return false;
    }
}
