package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, Integer> {
    @Procedure("add_regisseur")
    int addRegisseur(String name, String secondName, String gender, String placeOfBirth,
                         int filmsNumber);

    @Procedure("add_existing_regisseur")
    int addExistingRegisseur(int mainWorkerId, int filmsNumber);

    @Procedure("delete_regisseur")
    boolean deleteRegisseur(int mainWorkerId);

    @Procedure("associate_regisseur_and_location_process")
    boolean associateRegisseurAndLocationProcess(int workerId, int processId);

    @Procedure("associate_regisseur_and_plot_process")
    boolean associateRegisseurAndPlotProcess(int workerId, int processId);
}
