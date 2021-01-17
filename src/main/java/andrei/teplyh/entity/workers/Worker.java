package andrei.teplyh.entity.workers;

import andrei.teplyh.entity.Artifact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "workers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker {
    @Id
    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private int age;

    @Column(name = "PLACE_OF_BIRTH")
    private String birthPlace;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @OneToMany(mappedBy = "worker")
    private List<Artifact> artifacts = new ArrayList<>();

    public int getMainWorkerId() {
        return mainWorkerId;
    }
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    @Override
    public String toString() {
        return String.format("name = %s | gender = %s | age = %d | birthPlace = %s | secondName = %s",
                name, gender, age, birthPlace, secondName);
    }
}
