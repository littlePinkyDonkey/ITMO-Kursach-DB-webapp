package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.processes.CharacterDescriptionProcess;
import andrei.teplyh.entity.processes.CharacterDrawingProcess;
import andrei.teplyh.entity.processes.CharacterSelectProcess;
import andrei.teplyh.entity.processes.VoiceActingProcess;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "character")
public class Character {
    @Id
    @Column(name = "CHARACTER_ID")
    private int characterId;

    @ManyToOne
    @JoinColumn(name = "VOICE_ACTING_ID")
    private VoiceActingProcess voiceActingProcess;

    @ManyToOne
    @JoinColumn(name = "SELECTION_ID")
    private CharacterSelectProcess selectProcess;

    @ManyToOne
    @JoinColumn(name = "DRAWING_ID")
    private CharacterDrawingProcess drawingProcess;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private CharacterDescriptionProcess descriptionProcess;

    @Column(name = "CHARACTER_NAME")
    private String name;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PROTAGONIST")
    private boolean protagonist;

    @Column(name = "POSITIVE")
    private boolean positive;

    @Column(name = "AGE")
    private int age;

    @Column(name = "BIRTH_DATE")
    private Timestamp birthDate;

    public int getCharacterId() {
        return characterId;
    }
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public VoiceActingProcess getVoiceActingProcess() {
        return voiceActingProcess;
    }
    public void setVoiceActingProcess(VoiceActingProcess voiceActingProcess) {
        this.voiceActingProcess = voiceActingProcess;
    }

    public CharacterSelectProcess getSelectProcess() {
        return selectProcess;
    }
    public void setSelectProcess(CharacterSelectProcess selectProcess) {
        this.selectProcess = selectProcess;
    }

    public CharacterDrawingProcess getDrawingProcess() {
        return drawingProcess;
    }
    public void setDrawingProcess(CharacterDrawingProcess drawingProcess) {
        this.drawingProcess = drawingProcess;
    }

    public CharacterDescriptionProcess getDescriptionProcess() {
        return descriptionProcess;
    }
    public void setDescriptionProcess(CharacterDescriptionProcess descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
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

    public boolean isProtagonist() {
        return protagonist;
    }
    public void setProtagonist(boolean protagonist) {
        this.protagonist = protagonist;
    }

    public boolean isPositive() {
        return positive;
    }
    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }
}
