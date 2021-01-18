package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Procedure("create_locations")
    boolean createLocation(int descriptionId, int drawingId, int area, String locationType, boolean forBattle, String name);

    @Procedure("delete_locations")
    boolean deleteLocation(int locationId);

    @Procedure("associate_battle_and_location")
    boolean associateBattleAndLocation(int locationId, int battleId);

    @Procedure("associate_event_and_location")
    boolean associateEventAndLocation(int locationId, int eventId);
}
