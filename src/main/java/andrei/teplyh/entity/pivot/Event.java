package andrei.teplyh.entity.pivot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "events_plots",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLOT_ID")
    )
    private List<Plot> plots = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_location",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "LOCATION_ID")
    )
    private List<Location> locations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "events_characters",
            joinColumns = @JoinColumn(name = "EVENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHARACTER_ID")
    )
    private List<Character> characters = new ArrayList<>();

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
