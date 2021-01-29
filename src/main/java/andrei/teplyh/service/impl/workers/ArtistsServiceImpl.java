package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Artist;
import andrei.teplyh.repository.workers.ArtistsRepository;
import andrei.teplyh.service.workers.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistsServiceImpl implements ArtistsService {
    private final ArtistsRepository artistsRepository;

    @Autowired
    public ArtistsServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @Override
    public List<Artist> findAll() {
        return null;
    }

    @Override
    public int addArtist(String name, String secondName, String gender, String placeOfBirth, String artistType, String usingTechnology) {
        return 0;
    }

    @Override
    public int addExistingArtist(int mainWorkerId, String artistType, String usingTechnology) {
        return artistsRepository.addExistingArtist(mainWorkerId, artistType, usingTechnology);
    }

    @Override
    public boolean deleteArtist(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateArtistAndColoringProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateArtistAndAnimationProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateArtistAndEffectsProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateArtistAndLocationDrawingProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateArtistAndBattleDrawingProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateArtistAndCharacterDrawingProcess(int workerId, int processId) {
        return false;
    }
}
