package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.RevisionsProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/revisions_process")
public class RevisionsProcessController {
    private final RevisionsProcessService revisionsProcessService;

    @Autowired
    public RevisionsProcessController(RevisionsProcessService revisionsProcessService) {
        this.revisionsProcessService = revisionsProcessService;
    }
}
