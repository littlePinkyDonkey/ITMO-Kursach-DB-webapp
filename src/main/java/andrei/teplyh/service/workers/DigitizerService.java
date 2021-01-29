package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Digitizer;

import java.util.List;

public interface DigitizerService {
    List<Digitizer> findAll();

    int addDigitizer(String name, String secondName, String gender, String placeOfBirth);

    int addExistingDigitizer(int mainWorkerId);

    boolean deleteDigitizer(int mainWorkerId);

    boolean associateDigitizerAndProcess(int workerId, int processId);
}
