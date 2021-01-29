package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Screenwriter;
import andrei.teplyh.repository.workers.ScreenwriterRepository;
import andrei.teplyh.service.workers.ScreenwriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenwriterServiceImpl implements ScreenwriterService {
    private final ScreenwriterRepository screenwriterRepository;

    @Autowired
    public ScreenwriterServiceImpl(ScreenwriterRepository screenwriterRepository) {
        this.screenwriterRepository = screenwriterRepository;
    }

    @Override
    public List<Screenwriter> findAll() {
        return null;
    }

    @Override
    public int addScreenwriter(String name, String secondName, String gender, String placeOfBirth, int filmsNumber) {
        return 0;
    }

    @Override
    public int addExistingScreenwriter(int mainWorkerId, int filmsNumber) {
        return screenwriterRepository.addExistingScreenwriter(mainWorkerId, filmsNumber);
    }

    @Override
    public boolean deleteScreenwriter(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateScreenwriterAndBattleProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateScreenwriterAndPlotProcess(int workerId, int processId) {
        return false;
    }
}
