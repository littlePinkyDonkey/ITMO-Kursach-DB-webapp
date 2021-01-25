package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.SmoothingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/smoothing_process")
public class SmoothingProcessController {
    private final SmoothingProcessService smoothingProcessService;

    @Autowired
    public SmoothingProcessController(SmoothingProcessService smoothingProcessService) {
        this.smoothingProcessService = smoothingProcessService;
    }
}
