package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.BattleDrawingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/battle_drawing_process")
public class BattleDrawingProcessController {
    private final BattleDrawingProcessService battleDrawingProcessService;

    @Autowired
    public BattleDrawingProcessController(BattleDrawingProcessService battleDrawingProcessService) {
        this.battleDrawingProcessService = battleDrawingProcessService;
    }
}
