package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.StoryboardArtist;

import java.util.List;

public interface StoryboardArtistService {
    List<StoryboardArtist> findAll();

    int addStoryboardArtist(String name, String secondName, String gender, String placeOfBirth);

    int addExistingStoryboardArtist(int mainWorkerId);

    boolean deleteStoryboardArtist(int mainWorkerId);

    boolean associateStoryboarderAndProcess(int workerId, int processId);
}
