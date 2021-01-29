package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Screenwriter;

import java.util.List;

public interface ScreenwriterService {
    List<Screenwriter> findAll();

    int addScreenwriter(String name, String secondName, String gender, String placeOfBirth,
                        int filmsNumber);

    int addExistingScreenwriter(int mainWorkerId, int filmsNumber);

    boolean deleteScreenwriter(int mainWorkerId);

    boolean associateScreenwriterAndBattleProcess(int workerId, int processId);

    boolean associateScreenwriterAndPlotProcess(int workerId, int processId);
}
