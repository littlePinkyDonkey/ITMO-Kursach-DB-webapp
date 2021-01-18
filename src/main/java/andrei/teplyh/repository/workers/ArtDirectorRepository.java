package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.ArtDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtDirectorRepository extends JpaRepository<ArtDirector, Integer> {
    @Procedure("add_art_director")
    boolean addArtDirector(String name, String secondName, String gender, int age, String placeOfBirth);

    @Procedure("add_existing_art_director")
    boolean addExistingArtDirector(int mainWorkerId);

    @Procedure("delete_art_director")
    boolean deleteArtDirector(int mainWorkerId);

    @Procedure("associate_art_director_and_process")
    boolean associateArtDirectorAndProcess(int workerId, int processId);
}
