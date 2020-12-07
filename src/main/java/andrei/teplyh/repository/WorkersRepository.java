package andrei.teplyh.repository;

import andrei.teplyh.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
}
