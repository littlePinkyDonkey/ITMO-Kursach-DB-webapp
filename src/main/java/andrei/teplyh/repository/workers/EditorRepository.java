package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}
