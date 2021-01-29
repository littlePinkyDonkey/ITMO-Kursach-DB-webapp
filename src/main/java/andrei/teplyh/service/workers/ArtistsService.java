package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Artist;

import java.util.List;

public interface ArtistsService {
    List<Artist> findAll();

    int addArtist(String name, String secondName, String gender, String placeOfBirth,
                  String artistType, String usingTechnology);

    int addExistingArtist(int mainWorkerId, String artistType, String usingTechnology);

    boolean deleteArtist(int mainWorkerId);

    boolean associateArtistAndColoringProcess(int workerId, int processId);

    boolean associateArtistAndAnimationProcess(int workerId, int processId);

    boolean associateArtistAndEffectsProcess(int workerId, int processId);

    boolean associateArtistAndLocationDrawingProcess(int workerId, int processId);

    boolean associateArtistAndBattleDrawingProcess(int workerId, int processId);

    boolean associateArtistAndCharacterDrawingProcess(int workerId, int processId);
}
