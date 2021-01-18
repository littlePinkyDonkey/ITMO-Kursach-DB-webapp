package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.enums.ArtistTypes;
import andrei.teplyh.entity.enums.UsingTechnologies;
import andrei.teplyh.entity.processes.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "artist_coloring_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<ColoringProcess> coloringProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_animation_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AnimationProcess> animationProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_effects_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AddingEffectProcess> addingEffectProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_location_drawing_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<LocationDrawingProcess> locationDrawingProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_battle_drawing_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<BattleDrawingProcess> battleDrawingProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "artist_character_drawing_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<CharacterDrawingProcess> characterDrawingProcesses = new ArrayList<>();

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

    public List<ColoringProcess> getColoringProcesses() {
        return coloringProcesses;
    }
    public void setColoringProcesses(List<ColoringProcess> coloringProcesses) {
        this.coloringProcesses = coloringProcesses;
    }

    public List<AnimationProcess> getAnimationProcesses() {
        return animationProcesses;
    }
    public void setAnimationProcesses(List<AnimationProcess> animationProcesses) {
        this.animationProcesses = animationProcesses;
    }

    public List<AddingEffectProcess> getAddingEffectProcesses() {
        return addingEffectProcesses;
    }
    public void setAddingEffectProcesses(List<AddingEffectProcess> addingEffectProcesses) {
        this.addingEffectProcesses = addingEffectProcesses;
    }

    public List<LocationDrawingProcess> getLocationDrawingProcesses() {
        return locationDrawingProcesses;
    }
    public void setLocationDrawingProcesses(List<LocationDrawingProcess> locationDrawingProcesses) {
        this.locationDrawingProcesses = locationDrawingProcesses;
    }

    public List<BattleDrawingProcess> getBattleDrawingProcesses() {
        return battleDrawingProcesses;
    }
    public void setBattleDrawingProcesses(List<BattleDrawingProcess> battleDrawingProcesses) {
        this.battleDrawingProcesses = battleDrawingProcesses;
    }

    public List<CharacterDrawingProcess> getCharacterDrawingProcesses() {
        return characterDrawingProcesses;
    }
    public void setCharacterDrawingProcesses(List<CharacterDrawingProcess> characterDrawingProcesses) {
        this.characterDrawingProcesses = characterDrawingProcesses;
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
