package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.Editor;

import java.util.List;

public interface EditorService {
    List<Editor> findAll();

    int addEditor(String name, String secondName, String gender, String placeOfBirth,
                  String position);

    int addExistingEditor(int mainWorkerId, String position);

    boolean deleteEditor(int mainWorkerId);

    boolean associateEditorAndProcess(int workerId, int processId);
}
