package andrei.teplyh.entity;

import andrei.teplyh.entity.enums.ArtifactTypes;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.entity.workers.Worker;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "FILE_LINK")
    private String filePath;

    @ManyToMany
    @JoinTable(
            name = "process_artifact",
            joinColumns = @JoinColumn(name = "ARTIFACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "MAIN_PROCESS_ID")
    )
    private List<Process> processes = new ArrayList<>();

    public int getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    public Worker getWorker() {
        return worker;
    }
    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public ArtifactTypes getArtifactType() {
        return artifactType;
    }
    public void setArtifactType(ArtifactTypes artifactType) {
        this.artifactType = artifactType;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    public List<Process> getProcesses() {
        return processes;
    }
    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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
