package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.CharacterSelectProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/character_select_process")
public class CharacterSelectProcessController {
    private final CharacterSelectProcessService characterSelectProcessService;

    @Autowired
    public CharacterSelectProcessController(CharacterSelectProcessService characterSelectProcessService) {
        this.characterSelectProcessService = characterSelectProcessService;
    }
}
