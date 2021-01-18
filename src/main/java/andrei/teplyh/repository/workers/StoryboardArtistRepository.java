package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.StoryboardArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryboardArtistRepository extends JpaRepository<StoryboardArtist, Integer> {
    @Procedure("add_storyboard_artist")
    boolean addStoryboardArtist(String name, String secondName, String gender, int age, String placeOfBirth);

    @Procedure("add_existing_storyboard_artist")
    boolean addExistingStoryboardArtist(int mainWorkerId);

    @Procedure("delete_storyboarder")
    boolean deleteStoryboardArtist(int mainWorkerId);

    @Procedure("associate_storyboarder_and_process")
    boolean associateStoryboarderAndProcess(int workerId, int processId);
}
