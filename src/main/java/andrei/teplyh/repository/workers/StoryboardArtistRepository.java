package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.StoryboardArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryboardArtistRepository extends JpaRepository<StoryboardArtist, Long> {
}
