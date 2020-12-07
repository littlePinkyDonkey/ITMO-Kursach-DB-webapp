package andrei.teplyh.dao.repository;

import andrei.teplyh.dao.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
}
