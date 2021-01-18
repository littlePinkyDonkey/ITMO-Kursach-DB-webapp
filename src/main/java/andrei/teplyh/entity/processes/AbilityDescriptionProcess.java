package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.pivot.Ability;
import andrei.teplyh.entity.workers.RolesDesigner;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ability_description_process")
public class AbilityDescriptionProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @OneToMany(mappedBy = "descriptionProcess")
    private List<Ability> abilities = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "designer_ability_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<RolesDesigner> workers = new ArrayList<>();

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

    public List<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<RolesDesigner> getWorkers() {
        return workers;
    }
    public void setWorkers(List<RolesDesigner> workers) {
        this.workers = workers;
    }
}
