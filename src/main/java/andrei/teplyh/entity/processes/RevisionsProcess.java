package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.enums.RevisionTypes;
import andrei.teplyh.entity.workers.ArtDirector;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "revisions_process")
public class RevisionsProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Transient
    private RevisionTypes revisionType;

    @Column(name = "REVISION_TYPE")
    private String revisionValue;

    @ManyToMany
    @JoinTable(
            name = "art_director_revision_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<ArtDirector> workers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_storyboarding",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<StoryboardProcess> storyboardProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_adding_sound",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AddingSoundProcess> addingSoundProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_smoothing",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<SmoothingProcess> smoothingProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_adding_effects",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AddingEffectProcess> addingEffectProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_animation",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AnimationProcess> animationProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "revision_coloring",
            joinColumns = @JoinColumn(name = "REVISION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<ColoringProcess> coloringProcesses = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    @Override
    public int getMainProcessId() {
        return mainProcessId;
    }
    @Override
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

    public RevisionTypes getRevisionType() {
        return revisionType;
    }
    public void setRevisionType(RevisionTypes revisionType) {
        this.revisionType = revisionType;
    }

    public List<ArtDirector> getWorkers() {
        return workers;
    }
    public void setWorkers(List<ArtDirector> workers) {
        this.workers = workers;
    }

    public List<StoryboardProcess> getStoryboardProcesses() {
        return storyboardProcesses;
    }
    public void setStoryboardProcesses(List<StoryboardProcess> storyboardProcesses) {
        this.storyboardProcesses = storyboardProcesses;
    }

    public List<AddingSoundProcess> getAddingSoundProcesses() {
        return addingSoundProcesses;
    }
    public void setAddingSoundProcesses(List<AddingSoundProcess> addingSoundProcesses) {
        this.addingSoundProcesses = addingSoundProcesses;
    }

    public List<SmoothingProcess> getSmoothingProcesses() {
        return smoothingProcesses;
    }
    public void setSmoothingProcesses(List<SmoothingProcess> smoothingProcesses) {
        this.smoothingProcesses = smoothingProcesses;
    }

    public List<AddingEffectProcess> getAddingEffectProcesses() {
        return addingEffectProcesses;
    }
    public void setAddingEffectProcesses(List<AddingEffectProcess> addingEffectProcesses) {
        this.addingEffectProcesses = addingEffectProcesses;
    }

    public List<AnimationProcess> getAnimationProcesses() {
        return animationProcesses;
    }
    public void setAnimationProcesses(List<AnimationProcess> animationProcesses) {
        this.animationProcesses = animationProcesses;
    }

    public List<ColoringProcess> getColoringProcesses() {
        return coloringProcesses;
    }
    public void setColoringProcesses(List<ColoringProcess> coloringProcesses) {
        this.coloringProcesses = coloringProcesses;
    }

    @PrePersist
    public void prePersist() {
        if (revisionType != null)
            this.revisionValue = revisionType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (revisionValue != null)
            this.revisionType = RevisionTypes.of(revisionValue);
    }
}
