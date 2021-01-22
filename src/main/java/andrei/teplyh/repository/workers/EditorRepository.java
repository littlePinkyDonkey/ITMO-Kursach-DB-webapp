package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {
    @Procedure("add_editor")
    int addEditor(String name, String secondName, String gender, String placeOfBirth,
                      String position);

    @Procedure("add_existing_editor")
    int addExistingEditor(int mainWorkerId, String position);

    @Procedure("delete_editor")
    boolean deleteEditor(int mainWorkerId);

    @Procedure("associate_editor_and_process")
    boolean associateEditorAndProcess(int workerId, int processId);
}
