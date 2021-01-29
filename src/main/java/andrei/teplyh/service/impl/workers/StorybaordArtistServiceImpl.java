package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.StoryboardArtist;
import andrei.teplyh.repository.workers.StoryboardArtistRepository;
import andrei.teplyh.service.workers.StoryboardArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorybaordArtistServiceImpl implements StoryboardArtistService {
    private final StoryboardArtistRepository storyboardArtistRepository;

    @Autowired
    public StorybaordArtistServiceImpl(StoryboardArtistRepository storyboardArtistRepository) {
        this.storyboardArtistRepository = storyboardArtistRepository;
    }

    @Override
    public List<StoryboardArtist> findAll() {
        return null;
    }

    @Override
    public int addStoryboardArtist(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingStoryboardArtist(int mainWorkerId) {
        return storyboardArtistRepository.addExistingStoryboardArtist(mainWorkerId);
    }

    @Override
    public boolean deleteStoryboardArtist(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateStoryboarderAndProcess(int workerId, int processId) {
        return false;
    }
}
