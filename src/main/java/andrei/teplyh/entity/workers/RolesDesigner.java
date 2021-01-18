package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.processes.AbilityDescriptionProcess;
import andrei.teplyh.entity.processes.CharacterDescriptionProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles_designers")
public class RolesDesigner extends Worker{
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @ManyToMany
    @JoinTable(
            name = "designer_ability_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<AbilityDescriptionProcess> abilityDescriptionProcesses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "designer_character_process",
            joinColumns = @JoinColumn(name = "WORKER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROCESS_ID")
    )
    private List<CharacterDescriptionProcess> characterDescriptionProcesses = new ArrayList<>();

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public List<AbilityDescriptionProcess> getAbilityDescriptionProcesses() {
        return abilityDescriptionProcesses;
    }
    public void setAbilityDescriptionProcesses(List<AbilityDescriptionProcess> abilityDescriptionProcesses) {
        this.abilityDescriptionProcesses = abilityDescriptionProcesses;
    }

    public List<CharacterDescriptionProcess> getCharacterDescriptionProcesses() {
        return characterDescriptionProcesses;
    }
    public void setCharacterDescriptionProcesses(List<CharacterDescriptionProcess> characterDescriptionProcesses) {
        this.characterDescriptionProcesses = characterDescriptionProcesses;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d", super.toString(), workerId);
    }
}
