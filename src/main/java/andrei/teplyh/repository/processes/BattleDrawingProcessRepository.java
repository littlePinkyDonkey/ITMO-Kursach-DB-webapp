package andrei.teplyh.repository.processes;

import andrei.teplyh.entity.processes.BattleDrawingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface BattleDrawingProcessRepository extends JpaRepository<BattleDrawingProcess, Integer> {
    @Procedure("create_battle_drawing_process")
    boolean createBattleDrawingProcess(int duration, Timestamp deadlineDate, String description, String status, Timestamp startDate);

    @Procedure("create_existing_battle_drawing_process")
    boolean createExistingBattleDrawingProcess(int mainProcessId);

    @Procedure("delete_battle_drawing_process")
    boolean deleteBattleDrawingProcess(int mainProcessId);
}
