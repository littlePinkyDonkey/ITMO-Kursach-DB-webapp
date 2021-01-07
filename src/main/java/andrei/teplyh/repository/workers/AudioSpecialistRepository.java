package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.AudioSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioSpecialistRepository extends JpaRepository<AudioSpecialist, Long> {
}
