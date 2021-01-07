package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.ArtDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtDirectorRepository extends JpaRepository<ArtDirector, Long> {
}
