package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.AbilityDescriptionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/ability_description_process")
public class AbilityDescriptionProcessController {
    private final AbilityDescriptionProcessService abilityDescriptionProcessService;

    @Autowired
    public AbilityDescriptionProcessController(AbilityDescriptionProcessService abilityDescriptionProcessService) {
        this.abilityDescriptionProcessService = abilityDescriptionProcessService;
    }
}
