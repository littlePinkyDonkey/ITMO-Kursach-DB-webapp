package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Screenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenwriterRepository extends JpaRepository<Screenwriter, Long> {
}
