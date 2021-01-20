package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
    @Procedure("add_artist")
    int addArtist(String name, String secondName, String gender, int age, String placeOfBirth,
                      String artistType, String usingTechnology);

    @Procedure("add_existing_artist")
    int addExistingArtist(int mainWorkerId, String artistType, String usingTechnology);

    @Procedure("delete_artist")
    boolean deleteArtist(int mainWorkerId);

    @Procedure("associate_artist_and_coloring_process")
    boolean associateArtistAndColoringProcess(int workerId, int processId);

    @Procedure("associate_artist_and_animation_process")
    boolean associateArtistAndAnimationProcess(int workerId, int processId);

    @Procedure("associate_artist_and_effects_process")
    boolean associateArtistAndEffectsProcess(int workerId, int processId);

    @Procedure("associate_artist_and_location_drawing_process")
    boolean associateArtistAndLocationDrawingProcess(int workerId, int processId);

    @Procedure("associate_artist_and_battle_drawing_process")
    boolean associateArtistAndBattleDrawingProcess(int workerId, int processId);

    @Procedure("associate_artist_and_character_drawing_process")
    boolean associateArtistAndCharacterDrawingProcess(int workerId, int processId);
}
