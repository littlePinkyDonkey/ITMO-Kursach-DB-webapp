package andrei.teplyh.dao.repository;

import andrei.teplyh.dao.entity.StoryboardArtist;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryboardArtistRepository extends CrudRepository<StoryboardArtist, Long> {
}
