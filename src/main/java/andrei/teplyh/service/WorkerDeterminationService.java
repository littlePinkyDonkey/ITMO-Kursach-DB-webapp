package andrei.teplyh.service;

import java.util.List;

public interface WorkerDeterminationService {
    void addWorker(List<String> roles, int mainWorkerId);
}
