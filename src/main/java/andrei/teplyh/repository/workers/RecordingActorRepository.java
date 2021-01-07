package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.RecordingActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingActorRepository extends JpaRepository<RecordingActor, Long> {
}
