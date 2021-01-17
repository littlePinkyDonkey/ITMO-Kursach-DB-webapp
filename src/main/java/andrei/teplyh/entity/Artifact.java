package andrei.teplyh.entity;

import andrei.teplyh.entity.enums.ArtifactTypes;
import andrei.teplyh.entity.workers.Worker;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "artifacts")
public class Artifact {
    @Id
    @Column(name = "ARTIFACT_ID")
    private int artifactId;

    @ManyToOne
    @JoinColumn(name = "MAIN_WORKER_ID")
    private Worker worker;

    @Transient
    private ArtifactTypes artifactType;

    @Column(name = "ARTIFACT_TYPE")
    private String artifactValue;

    @Column(name = "SIZE")
    private int size;

    @Column(name = "UPLOAD_DATE")
    private Timestamp uploadDate;

    @PrePersist
    public void perPersist() {
        if (artifactType != null)
            this.artifactValue = artifactType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (artifactValue != null)
            this.artifactType = ArtifactTypes.of(artifactValue);
    }
}
