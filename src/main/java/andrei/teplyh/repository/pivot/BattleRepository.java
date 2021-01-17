package andrei.teplyh.repository.pivot;

import andrei.teplyh.entity.pivot.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer> {
    @Procedure("create_battle")
    boolean createBattle(int descriptionId, int drawingId, float duration, String name);

    @Procedure("delete_battle")
    boolean deleteBattle(int battleId);
}
