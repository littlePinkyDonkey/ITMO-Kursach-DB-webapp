package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.EditorPositions;
import andrei.teplyh.entity.processes.CharacterSelectProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "editors")
public class Editor extends Worker{
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Transient
    private EditorPositions editorPosition;

    @Column(name = "POSITION")
    private String editorValue;

    @ManyToMany
    @JoinTable(
            name = "editors_character_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<CharacterSelectProcess> processes = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public EditorPositions getEditorPosition() {
        return editorPosition;
    }
    public void setEditorPosition(EditorPositions editorPosition) {
        this.editorPosition = editorPosition;
    }

    public List<CharacterSelectProcess> getProcesses() {
        return processes;
    }
    public void setProcesses(List<CharacterSelectProcess> processes) {
        this.processes = processes;
    }

    @PrePersist
    public void prePersist() {
        if (editorPosition != null)
            this.editorValue = editorPosition.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (editorValue != null)
            this.editorPosition = EditorPositions.of(editorValue);
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id  =%d", super.toString(), workerId, mainWorkerId);
    }
}
