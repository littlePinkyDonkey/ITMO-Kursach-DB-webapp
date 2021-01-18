package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.processes.BattleDescriptionProcess;
import andrei.teplyh.entity.processes.BattleDrawingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "battle")
public class Battle {
    @Id
    @Column(name = "BATTLE_ID")
    private int battleId;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private BattleDescriptionProcess descriptionProcess;

    @ManyToOne
    @JoinColumn(name = "DRAWING_ID")
    private BattleDrawingProcess battleDrawingProcess;

    @Column(name = "BATTLE_NAME")
    private String name;

    @Column(name = "DURATION")
    private float duration;

    @ManyToMany
    @JoinTable(
            name = "battle_location",
            joinColumns = @JoinColumn(name = "BATTLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LOCATION_ID")
    )
    private List<Location> locations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "battle_abilities",
            joinColumns = @JoinColumn(name = "BATTLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ABILITY_ID")
    )
    private List<Ability> abilities = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "battle_characters",
            joinColumns = @JoinColumn(name = "BATTLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID")
    )
    private List<Character> characters = new ArrayList<>();

    public int getBattleId() {
        return battleId;
    }
    public void setBattleId(int battleId) {
        this.battleId = battleId;
    }

    public BattleDescriptionProcess getDescriptionProcess() {
        return descriptionProcess;
    }
    public void setDescriptionProcess(BattleDescriptionProcess descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public BattleDrawingProcess getBattleDrawingProcess() {
        return battleDrawingProcess;
    }
    public void setBattleDrawingProcess(BattleDrawingProcess battleDrawingProcess) {
        this.battleDrawingProcess = battleDrawingProcess;
    }

    public List<Location> getLocations() {
        return locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
}
