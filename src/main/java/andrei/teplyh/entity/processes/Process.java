package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.Artifact;
import andrei.teplyh.entity.Product;
import andrei.teplyh.entity.enums.ProcessStatuses;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "processes")
public class Process {
    @Id
    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "DURATION")
    private int duration;

    @Column(name = "DEADLINE_DATE")
    private Timestamp deadlineDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private ProcessStatuses status;

    @Column(name = "STATUS")
    private String processStatus;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @OneToOne(mappedBy = "process")
    private AbilityDescriptionProcess abilityDescriptionProcess;

    @OneToOne(mappedBy = "process")
    private AddingEffectProcess addingEffectProcess;

    @OneToOne(mappedBy = "process")
    private AddingSoundProcess addingSoundProcess;

    @OneToOne(mappedBy = "process")
    private AdvertisingProcess advertisingProcess;

    @OneToOne(mappedBy = "process")
    private AnimationProcess animationProcess;

    @OneToOne(mappedBy = "process")
    private BattleDrawingProcess battleDrawingProcess;

    @OneToOne(mappedBy = "process")
    private BattleDescriptionProcess battleDescriptionProcess;

    @OneToOne(mappedBy = "process")
    private CharacterDescriptionProcess characterDescriptionProcess;

    @OneToOne(mappedBy = "process")
    private CharacterDrawingProcess characterDrawingProcess;

    @OneToOne(mappedBy = "process")
    private CharacterSelectProcess characterSelectProcess;

    @OneToOne(mappedBy = "process")
    private ColoringProcess coloringProcess;

    @OneToOne(mappedBy = "process")
    private DigitizationProcess digitizationProcess;

    @OneToOne(mappedBy = "process")
    private LocationDescriptionProcess locationDescriptionProcess;

    @OneToOne(mappedBy = "process")
    private LocationDrawingProcess locationDrawingProcess;

    @OneToOne(mappedBy = "process")
    private PlotProcess plotProcess;

    @OneToOne(mappedBy = "process")
    private RevisionsProcess revisionsProcess;

    @OneToOne(mappedBy = "process")
    private SmoothingProcess smoothingProcess;

    @OneToOne(mappedBy = "process")
    private StoryboardProcess storyboardProcess;

    @OneToOne(mappedBy = "process")
    private VoiceActingProcess voiceActingProcess;

    @ManyToMany
    @JoinTable(
            name = "process_artifact",
            joinColumns = @JoinColumn(name = "MAIN_PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "ARTIFACT_ID")
    )
    private List<Artifact> artifacts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public AbilityDescriptionProcess getAbilityDescriptionProcess() {
        return abilityDescriptionProcess;
    }
    public void setAbilityDescriptionProcess(AbilityDescriptionProcess abilityDescriptionProcess) {
        this.abilityDescriptionProcess = abilityDescriptionProcess;
    }

    public AddingEffectProcess getAddingEffectProcess() {
        return addingEffectProcess;
    }
    public void setAddingEffectProcess(AddingEffectProcess addingEffectProcess) {
        this.addingEffectProcess = addingEffectProcess;
    }

    public AddingSoundProcess getAddingSoundProcess() {
        return addingSoundProcess;
    }
    public void setAddingSoundProcess(AddingSoundProcess addingSoundProcess) {
        this.addingSoundProcess = addingSoundProcess;
    }

    public AdvertisingProcess getAdvertisingProcess() {
        return advertisingProcess;
    }
    public void setAdvertisingProcess(AdvertisingProcess advertisingProcess) {
        this.advertisingProcess = advertisingProcess;
    }

    public AnimationProcess getAnimationProcess() {
        return animationProcess;
    }
    public void setAnimationProcess(AnimationProcess animationProcess) {
        this.animationProcess = animationProcess;
    }

    public BattleDrawingProcess getBattleDrawingProcess() {
        return battleDrawingProcess;
    }
    public void setBattleDrawingProcess(BattleDrawingProcess battleDrawingProcess) {
        this.battleDrawingProcess = battleDrawingProcess;
    }

    public BattleDescriptionProcess getBattleDescriptionProcess() {
        return battleDescriptionProcess;
    }
    public void setBattleDescriptionProcess(BattleDescriptionProcess battleDescriptionProcess) {
        this.battleDescriptionProcess = battleDescriptionProcess;
    }

    public CharacterDescriptionProcess getCharacterDescriptionProcess() {
        return characterDescriptionProcess;
    }
    public void setCharacterDescriptionProcess(CharacterDescriptionProcess characterDescriptionProcess) {
        this.characterDescriptionProcess = characterDescriptionProcess;
    }

    public CharacterDrawingProcess getCharacterDrawingProcess() {
        return characterDrawingProcess;
    }
    public void setCharacterDrawingProcess(CharacterDrawingProcess characterDrawingProcess) {
        this.characterDrawingProcess = characterDrawingProcess;
    }

    public CharacterSelectProcess getCharacterSelectProcess() {
        return characterSelectProcess;
    }
    public void setCharacterSelectProcess(CharacterSelectProcess characterSelectProcess) {
        this.characterSelectProcess = characterSelectProcess;
    }

    public ColoringProcess getColoringProcess() {
        return coloringProcess;
    }
    public void setColoringProcess(ColoringProcess coloringProcess) {
        this.coloringProcess = coloringProcess;
    }

    public DigitizationProcess getDigitizationProcess() {
        return digitizationProcess;
    }
    public void setDigitizationProcess(DigitizationProcess digitizationProcess) {
        this.digitizationProcess = digitizationProcess;
    }

    public LocationDescriptionProcess getLocationDescriptionProcess() {
        return locationDescriptionProcess;
    }
    public void setLocationDescriptionProcess(LocationDescriptionProcess locationDescriptionProcess) {
        this.locationDescriptionProcess = locationDescriptionProcess;
    }

    public LocationDrawingProcess getLocationDrawingProcess() {
        return locationDrawingProcess;
    }
    public void setLocationDrawingProcess(LocationDrawingProcess locationDrawingProcess) {
        this.locationDrawingProcess = locationDrawingProcess;
    }

    public PlotProcess getPlotProcess() {
        return plotProcess;
    }
    public void setPlotProcess(PlotProcess plotProcess) {
        this.plotProcess = plotProcess;
    }

    public RevisionsProcess getRevisionsProcess() {
        return revisionsProcess;
    }
    public void setRevisionsProcess(RevisionsProcess revisionsProcess) {
        this.revisionsProcess = revisionsProcess;
    }

    public SmoothingProcess getSmoothingProcess() {
        return smoothingProcess;
    }
    public void setSmoothingProcess(SmoothingProcess smoothingProcess) {
        this.smoothingProcess = smoothingProcess;
    }

    public StoryboardProcess getStoryboardProcess() {
        return storyboardProcess;
    }
    public void setStoryboardProcess(StoryboardProcess storyboardProcess) {
        this.storyboardProcess = storyboardProcess;
    }

    public VoiceActingProcess getVoiceActingProcess() {
        return voiceActingProcess;
    }
    public void setVoiceActingProcess(VoiceActingProcess voiceActingProcess) {
        this.voiceActingProcess = voiceActingProcess;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getMainProcessId() {
        return mainProcessId;
    }
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }
    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public ProcessStatuses getStatus() {
        return status;
    }
    public void setStatus(ProcessStatuses status) {
        this.status = status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    @PrePersist
    public void prePersist() {
        if (status != null)
            this.processStatus = status.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (processStatus != null)
            this.status = ProcessStatuses.of(processStatus);
    }

    @Override
    public String toString() {
        return "Process{" +
                "mainProcessId=" + mainProcessId +
                ", duration=" + duration +
                ", deadlineDate=" + deadlineDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", processStatus='" + processStatus + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
