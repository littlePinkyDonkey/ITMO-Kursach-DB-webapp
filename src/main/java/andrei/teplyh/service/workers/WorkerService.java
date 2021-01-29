package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();

    int addWorker(String name, String secondName, String gender, String placeOfBirth);

    boolean deleteWorker(int mainWorkerId);
}
