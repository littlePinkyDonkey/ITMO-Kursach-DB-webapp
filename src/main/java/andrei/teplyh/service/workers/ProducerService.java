package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Producer;

import java.util.List;

public interface ProducerService {
    List<Producer> findAll();

    int addProducer(String name, String secondName, String gender, String placeOfBirth, String role);

    int addExistingProducer(int mainWorkerId, String role);

    boolean deleteProducer(int mainWorkerId);

    boolean associateProducerAndProcess(int workerId, int processId);
}
