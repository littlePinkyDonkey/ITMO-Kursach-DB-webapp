package andrei.teplyh.controller.processes;


import andrei.teplyh.service.processes.BattleDescriptionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/battle_description_process")
public class BattleDescriptionProcessController {
    private final BattleDescriptionProcessService battleDescriptionProcessService;

    @Autowired
    public BattleDescriptionProcessController(BattleDescriptionProcessService battleDescriptionProcessService) {
        this.battleDescriptionProcessService = battleDescriptionProcessService;
    }
}
