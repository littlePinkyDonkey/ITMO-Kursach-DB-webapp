package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.AddingEffectProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/adding_effect_process")
public class AddingEffectProcessController {
    private final AddingEffectProcessService addingEffectProcessService;

    @Autowired
    public AddingEffectProcessController(AddingEffectProcessService addingEffectProcessService) {
        this.addingEffectProcessService = addingEffectProcessService;
    }
}
