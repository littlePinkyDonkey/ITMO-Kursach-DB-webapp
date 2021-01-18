package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.enums.AbilityTypes;
import andrei.teplyh.entity.processes.AbilityDescriptionProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "abilities")
public class Ability {
    @Id
    @Column(name = "ABILITY_ID")
    private int abilityId;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private AbilityDescriptionProcess descriptionProcess;

    @Column(name = "ABILITY_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient
    private AbilityTypes abilityType;

    @Column(name = "ABILITY_TYPE")
    private String abilityValue;

    @Column(name = "COMPLEXITY_LEVEL")
    private int complexityLevel;

    @ManyToMany
    @JoinTable(
            name = "battle_abilities",
            joinColumns = @JoinColumn(name = "ABILITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "BATTLE_ID")
    )
    private List<Battle> battles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "characters_abilities",
            joinColumns = @JoinColumn(name = "ABILITY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID")
    )
    private List<Character> characters = new ArrayList<>();

    public int getAbilityId() {
        return abilityId;
    }
    public void setAbilityId(int abilityId) {
        this.abilityId = abilityId;
    }

    public AbilityDescriptionProcess getDescriptionProcess() {
        return descriptionProcess;
    }
    public void setDescriptionProcess(AbilityDescriptionProcess descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public AbilityTypes getAbilityType() {
        return abilityType;
    }
    public void setAbilityType(AbilityTypes abilityType) {
        this.abilityType = abilityType;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }
    public void setComplexityLevel(int complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    @PrePersist
    public void prePersist() {
        if (abilityType != null)
            this.abilityValue = abilityType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (abilityValue != null)
            this.abilityType = AbilityTypes.of(abilityValue);
    }
}
