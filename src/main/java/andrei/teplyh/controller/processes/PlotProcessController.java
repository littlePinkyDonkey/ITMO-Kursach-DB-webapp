package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.PlotProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plot_process")
public class PlotProcessController {
    private final PlotProcessService plotProcessService;

    @Autowired
    public PlotProcessController(PlotProcessService plotProcessService) {
        this.plotProcessService = plotProcessService;
    }
}
