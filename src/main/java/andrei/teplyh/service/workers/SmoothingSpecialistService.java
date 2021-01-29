package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.SmoothingSpecialist;

import java.util.List;

public interface SmoothingSpecialistService {
    List<SmoothingSpecialist> findAll();

    int addSmoothingSpecialist(String name, String secondName, String gender, String placeOfBirth);

    int addExistingSmoothingSpecialist(int mainWorkerId);

    boolean deleteSmoothingSpecialist(int mainWorkerId);

    boolean associateSmootherAndProcess(int workerId, int processId);
}
