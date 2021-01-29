package andrei.teplyh.service;

import java.util.List;

public interface WorkerDispatcherService {
    void dispatch(List<String> roles, int mainWorkerId);
}
