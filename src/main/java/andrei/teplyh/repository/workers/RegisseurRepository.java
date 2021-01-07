package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisseurRepository extends JpaRepository<Regisseur, Long> {
}
