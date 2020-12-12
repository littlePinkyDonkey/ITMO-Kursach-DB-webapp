package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.EditorPositions;

import javax.persistence.*;

@Entity(name = "editors")
public class Editor {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    @Column(name = "GENRES")
    private String[] genres;

    @Transient
    private EditorPositions editorPosition;

    @Column(name = "EDITOR_POSITIONS")
    private String editorValue;

    public Editor() {
    }
    public Editor(long workerId, long mainWorkerId, String[] genres, EditorPositions editorPosition, String editorValue) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
        this.genres = genres;
        this.editorPosition = editorPosition;
        this.editorValue = editorValue;
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
}
