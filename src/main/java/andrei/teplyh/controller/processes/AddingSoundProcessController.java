package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.AddingSoundProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adding_sound_process")
public class AddingSoundProcessController {
    private final AddingSoundProcessService addingSoundProcessService;

    @Autowired
    public AddingSoundProcessController(AddingSoundProcessService addingSoundProcessService) {
        this.addingSoundProcessService = addingSoundProcessService;
    }
}
