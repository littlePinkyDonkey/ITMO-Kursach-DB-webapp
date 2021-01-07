package andrei.teplyh.repository.workers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitizerRepository extends JpaRepository<DigitizerRepository, Long> {
}
