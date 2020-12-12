package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Long> {

}
