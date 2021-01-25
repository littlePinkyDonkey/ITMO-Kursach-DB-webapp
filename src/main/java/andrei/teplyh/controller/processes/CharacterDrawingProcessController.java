package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.CharacterDrawingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/character_drawing_process")
public class CharacterDrawingProcessController {
    private final CharacterDrawingProcessService characterDrawingProcessService;

    @Autowired
    public CharacterDrawingProcessController(CharacterDrawingProcessService characterDrawingProcessService) {
        this.characterDrawingProcessService = characterDrawingProcessService;
    }
}
