package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Digitizer;
import andrei.teplyh.repository.workers.DigitizerRepository;
import andrei.teplyh.service.workers.DigitizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DigitizerServiceImpl implements DigitizerService {
    private final DigitizerRepository digitizerRepository;

    @Autowired
    public DigitizerServiceImpl(DigitizerRepository digitizerRepository) {
        this.digitizerRepository = digitizerRepository;
    }

    @Override
    public List<Digitizer> findAll() {
        return null;
    }

    @Override
    public int addDigitizer(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingDigitizer(int mainWorkerId) {
        return digitizerRepository.addExistingDigitizer(mainWorkerId);
    }

    @Override
    public boolean deleteDigitizer(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateDigitizerAndProcess(int workerId, int processId) {
        return false;
    }
}
