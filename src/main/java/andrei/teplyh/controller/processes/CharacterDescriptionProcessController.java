package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.CharacterDescriptionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/character_description_process")
public class CharacterDescriptionProcessController {
    private final CharacterDescriptionProcessService characterDescriptionProcessService;

    @Autowired
    public CharacterDescriptionProcessController(CharacterDescriptionProcessService characterDescriptionProcessService) {
        this.characterDescriptionProcessService = characterDescriptionProcessService;
    }
}
