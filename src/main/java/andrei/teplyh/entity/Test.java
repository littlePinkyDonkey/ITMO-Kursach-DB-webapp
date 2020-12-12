package andrei.teplyh.entity;

import andrei.teplyh.entity.enums.AbilityTypes;

import javax.persistence.*;

@Entity(name = "test")
public class Test {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Transient
    private AbilityTypes abilityType;

    @Column(name = "ability_type")
    private String abilityValue;

    public Test() {

    }
    public  Test(long id, String name, AbilityTypes abilityType) {
        this.id = id;
        this.name = name;
        this.abilityType = abilityType;
    }

    @PrePersist
    public void prePersist() {
        if (abilityType != null)
            abilityValue = abilityType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (abilityValue != null)
            abilityType = AbilityTypes.of(abilityValue);
    }

    @Override
    public String toString() {
        return String.format("name = %s || ability = %s", name, abilityValue);
    }
}
