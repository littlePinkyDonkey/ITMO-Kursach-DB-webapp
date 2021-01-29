package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Worker;
import andrei.teplyh.repository.workers.WorkersRepository;
import andrei.teplyh.service.workers.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkersRepository workersRepository;

    @Autowired
    public WorkerServiceImpl(WorkersRepository workersRepository) {
        this.workersRepository = workersRepository;
    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public int addWorker(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public boolean deleteWorker(int mainWorkerId) {
        return false;
    }
}
