package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ArtistTypes;
import andrei.teplyh.entity.enums.UsingTechnologies;

import javax.persistence.*;

@Entity(name = "artists")
public class Artist {
    @Id
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    @Transient
    private ArtistTypes artistType;

    @Column(name = "ARTIST_TYPE")
    private String artistValue;

    @Transient
    private UsingTechnologies usingTechnology;

    @Column(name = "USING_TECHNOLOGY")
    private String technologyValue;

    public Artist() {
    }
    public Artist(long workerId, long mainWorkerId, ArtistTypes artistType, String artistValue, UsingTechnologies usingTechnology, String technologyValue) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
        this.artistType = artistType;
        this.artistValue = artistValue;
        this.usingTechnology = usingTechnology;
        this.technologyValue = technologyValue;
    }

    @PrePersist
    public void prePersist() {
        if (artistType != null && usingTechnology != null) {
            this.artistValue = usingTechnology.getDescription();
            this.technologyValue = usingTechnology.getDescription();
        }
    }

    @PostLoad
    public void postLoad() {
        if (artistValue != null && technologyValue != null) {
            this.artistType = ArtistTypes.of(artistValue);
            this.usingTechnology = UsingTechnologies.of(technologyValue);
        }
    }

    @Override
    public String toString() {
        return String.format("artist_type = %s || artist_id = %d || using_technology = %s", artistValue, workerId, technologyValue);
    }
}
