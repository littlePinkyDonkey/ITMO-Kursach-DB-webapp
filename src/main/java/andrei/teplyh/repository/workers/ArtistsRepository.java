package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
    @Procedure("add_artist")
    boolean addArtist(String name, String secondName, String gender, int age, String placeOfBirth,
                      String artistType, String usingTechnology);

    @Procedure("add_existing_artist")
    boolean addExistingArtist(int mainWorkerId, String artistType, String usingTechnology);

    @Procedure("delete_artist")
    boolean deleteArtist(int mainWorkerId);
}
