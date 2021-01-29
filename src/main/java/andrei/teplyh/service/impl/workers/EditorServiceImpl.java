package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Editor;
import andrei.teplyh.repository.workers.EditorRepository;
import andrei.teplyh.service.workers.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorServiceImpl implements EditorService {
    private final EditorRepository editorRepository;

    @Autowired
    public EditorServiceImpl(EditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }

    @Override
    public List<Editor> findAll() {
        return null;
    }

    @Override
    public int addEditor(String name, String secondName, String gender, String placeOfBirth, String position) {
        return 0;
    }

    @Override
    public int addExistingEditor(int mainWorkerId, String position) {
        return editorRepository.addExistingEditor(mainWorkerId, position);
    }

    @Override
    public boolean deleteEditor(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateEditorAndProcess(int workerId, int processId) {
        return false;
    }
}
