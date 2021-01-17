package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Procedure("create_events")
    boolean createEvent(String description, int importanceLevel, String eventName);

    @Procedure("delete_events")
    boolean deleteEvent(int eventId);
}
