package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.ArtDirector;
import andrei.teplyh.repository.workers.ArtDirectorRepository;
import andrei.teplyh.service.workers.ArtDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtDirectorServiceImpl implements ArtDirectorService {
    private final ArtDirectorRepository artDirectorRepository;

    @Autowired
    public ArtDirectorServiceImpl(ArtDirectorRepository artDirectorRepository) {
        this.artDirectorRepository = artDirectorRepository;
    }

    @Override
    public List<ArtDirector> findAll() {
        return null;
    }

    @Override
    public int addArtDirector(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingArtDirector(int mainWorkerId) {
        return artDirectorRepository.addExistingArtDirector(mainWorkerId);
    }

    @Override
    public boolean deleteArtDirector(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateArtDirectorAndProcess(int workerId, int processId) {
        return false;
    }
}
