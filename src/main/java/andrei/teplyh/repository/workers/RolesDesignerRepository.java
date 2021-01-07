package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.RolesDesigner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDesignerRepository extends JpaRepository<RolesDesigner, Long> {
}
