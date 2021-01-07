package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
