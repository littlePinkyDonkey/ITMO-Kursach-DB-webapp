package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.SmoothingSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmoothingSpecialistRepository extends JpaRepository<SmoothingSpecialist, Long> {
}
