package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {
    @Procedure("add_editor")
    boolean addEditor(String name, String secondName, String gender, int age, String placeOfBirth,
                      String position);

    @Procedure("add_existing_editor")
    boolean addExistingEditor(int mainWorkerId, String position);

    @Procedure("delete_editor")
    boolean deleteEditor(int mainWorkerId);
}
