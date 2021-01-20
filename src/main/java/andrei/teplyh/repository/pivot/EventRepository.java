package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Procedure("create_events")
    int createEvent(String description, int importanceLevel, String eventName);

    @Procedure("delete_events")
    boolean deleteEvent(int eventId);

    @Procedure("associate_event_and_location")
    boolean associateEventAndLocation(int locationId, int eventId);

    @Procedure("associate_event_and_plot")
    boolean associateEventAndPlot(int eventId, int plotId);

    @Procedure("associate_event_and_character")
    boolean associateEventAndCharacter(int eventId, int characterId);
}
