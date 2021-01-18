package andrei.teplyh.entity.pivot;

import andrei.teplyh.entity.enums.LocationTypes;
import andrei.teplyh.entity.processes.LocationDescriptionProcess;
import andrei.teplyh.entity.processes.LocationDrawingProcess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "locations")
public class Location {
    @Id
    @Column(name = "LOCATION_ID")
    private int locationId;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private LocationDescriptionProcess descriptionProcess;

    @ManyToOne
    @JoinColumn(name = "DRAWING_ID")
    private LocationDrawingProcess drawingProcess;

    @Column(name = "LOCATION_NAME")
    private String name;

    @Column(name = "AREA")
    private int area;

    @Transient
    private LocationTypes locationType;

    @Column(name = "LOCATION_TYPE")
    private String locationValue;

    @Column(name = "FOR_BATTLE")
    private boolean forBattle;

    @ManyToMany
    @JoinTable(
            name = "event_location",
            joinColumns = @JoinColumn(name = "LOCATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "EVENT_ID")
    )
    private List<Event> events = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "battle_location",
            joinColumns = @JoinColumn(name = "LOCATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "BATTLE_ID")
    )
    private List<Battle> battles = new ArrayList<>();

    public int getLocationId() {
        return locationId;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public LocationDescriptionProcess getDescriptionProcess() {
        return descriptionProcess;
    }
    public void setDescriptionProcess(LocationDescriptionProcess descriptionProcess) {
        this.descriptionProcess = descriptionProcess;
    }

    public LocationDrawingProcess getDrawingProcess() {
        return drawingProcess;
    }
    public void setDrawingProcess(LocationDrawingProcess drawingProcess) {
        this.drawingProcess = drawingProcess;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }
    public void setArea(int area) {
        this.area = area;
    }

    public LocationTypes getLocationType() {
        return locationType;
    }
    public void setLocationType(LocationTypes locationType) {
        this.locationType = locationType;
    }

    public boolean isForBattle() {
        return forBattle;
    }
    public void setForBattle(boolean forBattle) {
        this.forBattle = forBattle;
    }

    @PrePersist
    public void prePersist() {
        if (locationType != null)
            this.locationValue = locationType.getDescription();
    }

    @PostLoad
    public void postLoad() {
        if (locationValue != null)
            this.locationType = LocationTypes.of(locationValue);
    }
}
