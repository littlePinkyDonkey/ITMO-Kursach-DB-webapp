package andrei.teplyh.entity.pivot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "events")
public class Event {
    @Id
    @Column(name = "EVENT_ID")
    private int eventId;

    @Column(name = "EVENT_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMPORTANCE_LEVEL")
    private int importanceLevel;

    public int getEventId() {
        return eventId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
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

    public int getImportanceLevel() {
        return importanceLevel;
    }
    public void setImportanceLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }
}
