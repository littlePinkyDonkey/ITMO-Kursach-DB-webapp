package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.EditorPositions;

import javax.persistence.*;

@Entity(name = "editors")
public class Editor extends Worker{
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Column(name = "GENRES")
    private String[] genres;

    @Transient
    private EditorPositions editorPosition;

    @Column(name = "EDITOR_POSITIONS")
    private String editorValue;

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

    public String[] getGenres() {
        return genres;
    }
    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public EditorPositions getEditorPosition() {
        return editorPosition;
    }
    public void setEditorPosition(EditorPositions editorPosition) {
        this.editorPosition = editorPosition;
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
