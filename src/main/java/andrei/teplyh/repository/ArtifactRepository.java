package andrei.teplyh.repository;

import andrei.teplyh.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
    @Procedure("create_artifact")
    int createArtifact(int uploadUser, String artifactType, int size, Timestamp uploadDate, String filePath);

    @Procedure("associate_artifact_and_process")
    boolean associateArtifactAndProcess(int artifactId, int mainProcessId);
}
