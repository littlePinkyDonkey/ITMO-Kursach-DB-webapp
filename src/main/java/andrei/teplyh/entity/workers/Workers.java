package andrei.teplyh.entity.workers;

import javax.persistence.*;

@Entity(name = "workers")
public class Workers {
    @Id
    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

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

    public Workers() {
    }
    public Workers(String name, String gender, int age, String birthPlace, String secondName) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthPlace = birthPlace;
        this.secondName = secondName;
    }

    public long getMainWorkerId() {
        return mainWorkerId;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public String getBirthPlace() {
        return birthPlace;
    }
    public String getSecondName() {
        return secondName;
    }

    public void setMainWorkerId(long mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return String.format("mainWorkerId = %d | name = %s | gender = %s | age = %d | birthPlace = %s | secondName = %s",
                mainWorkerId, name, gender, age, birthPlace, secondName);
    }
}
