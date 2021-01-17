package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, Integer> {
    @Procedure("add_regisseur")
    boolean addRegisseur(String name, String secondName, String gender, int age, String placeOfBirth,
                         int filmsNumber, String[] genres);

    @Procedure("add_existing_regisseur")
    boolean addExistingRegisseur(int mainWorkerId, int filmsNumber, String[] genres);

    @Procedure("delete_regisseur")
    boolean deleteRegisseur(int mainWorkerId);
}
