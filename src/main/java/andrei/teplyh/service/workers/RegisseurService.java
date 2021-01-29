package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Regisseur;

import java.util.List;

public interface RegisseurService {
    List<Regisseur> findAll();

    int addRegisseur(String name, String secondName, String gender, String placeOfBirth,
                     int filmsNumber);

    int addExistingRegisseur(int mainWorkerId, int filmsNumber);

    boolean deleteRegisseur(int mainWorkerId);

    boolean associateRegisseurAndLocationProcess(int workerId, int processId);

    boolean associateRegisseurAndPlotProcess(int workerId, int processId);
}
