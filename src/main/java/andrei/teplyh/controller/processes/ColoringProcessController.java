package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.ColoringProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coloring_process")
public class ColoringProcessController {
    private final ColoringProcessService coloringProcessService;

    @Autowired
    public ColoringProcessController(ColoringProcessService coloringProcessService) {
        this.coloringProcessService = coloringProcessService;
    }
}
