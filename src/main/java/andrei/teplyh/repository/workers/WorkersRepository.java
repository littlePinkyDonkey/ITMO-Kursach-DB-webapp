package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
}
