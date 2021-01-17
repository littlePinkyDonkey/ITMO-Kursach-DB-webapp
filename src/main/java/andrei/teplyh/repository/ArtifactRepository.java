package andrei.teplyh.repository;

import andrei.teplyh.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
    @Procedure("create_artifact")
    boolean createArtifact(int uploadUser, String artifactType, int size, Date uploadDate);
}
