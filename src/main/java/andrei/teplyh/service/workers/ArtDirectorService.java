package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.ArtDirector;

import java.util.List;

public interface ArtDirectorService {
    List<ArtDirector> findAll();

    int addArtDirector(String name, String secondName, String gender, String placeOfBirth);

    int addExistingArtDirector(int mainWorkerId);

    boolean deleteArtDirector(int mainWorkerId);

    boolean associateArtDirectorAndProcess(int workerId, int processId);
}
