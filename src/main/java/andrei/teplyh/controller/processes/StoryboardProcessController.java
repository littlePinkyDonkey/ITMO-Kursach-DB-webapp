package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.StoryboardProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/storyboard_process")
public class StoryboardProcessController {
    private final StoryboardProcessService storyboardProcessService;

    @Autowired
    public StoryboardProcessController(StoryboardProcessService storyboardProcessService) {
        this.storyboardProcessService = storyboardProcessService;
    }
}
