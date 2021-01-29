package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Regisseur;
import andrei.teplyh.repository.workers.RegisseurRepository;
import andrei.teplyh.service.workers.RegisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisseurServiceImpl implements RegisseurService {
    private final RegisseurRepository regisseurRepository;

    @Autowired
    public RegisseurServiceImpl(RegisseurRepository regisseurRepository) {
        this.regisseurRepository = regisseurRepository;
    }

    @Override
    public List<Regisseur> findAll() {
        return null;
    }

    @Override
    public int addRegisseur(String name, String secondName, String gender, String placeOfBirth, int filmsNumber) {
        return 0;
    }

    @Override
    public int addExistingRegisseur(int mainWorkerId, int filmsNumber) {
        return regisseurRepository.addExistingRegisseur(mainWorkerId, filmsNumber);
    }

    @Override
    public boolean deleteRegisseur(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateRegisseurAndLocationProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateRegisseurAndPlotProcess(int workerId, int processId) {
        return false;
    }
}
