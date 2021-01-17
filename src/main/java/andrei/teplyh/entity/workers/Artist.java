package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ArtistTypes;
import andrei.teplyh.entity.enums.UsingTechnologies;

import javax.persistence.*;

@Entity(name = "artists")
public class Artist extends Worker {
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Transient
    private ArtistTypes artistType;

    @Column(name = "ARTIST_TYPE")
    private String artistValue;

    @Transient
    private UsingTechnologies usingTechnology;

    @Column(name = "USING_TECHNOLOGY")
    private String technologyValue;

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public ArtistTypes getArtistType() {
        return artistType;
    }
    public void setArtistType(ArtistTypes artistType) {
        this.artistType = artistType;
    }

    public String getArtistValue() {
        return artistValue;
    }
    public void setArtistValue(String artistValue) {
        this.artistValue = artistValue;
    }

    public UsingTechnologies getUsingTechnology() {
        return usingTechnology;
    }
    public void setUsingTechnology(UsingTechnologies usingTechnology) {
        this.usingTechnology = usingTechnology;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
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
        return String.format("%s || workerId = %d || main_worker_id  =%d || artist_type = %s || artist_id = %d || using_technology = %s",
                super.toString(), workerId, mainWorkerId, artistValue, workerId, technologyValue);
    }
}
