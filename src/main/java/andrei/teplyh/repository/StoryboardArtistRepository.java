package andrei.teplyh.repository;

import andrei.teplyh.entity.StoryboardArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryboardArtistRepository extends JpaRepository<StoryboardArtist, Long> {
}
