package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.DigitizationProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/digitization_process")
public class DigitizationProcessController {
    private final DigitizationProcessService digitizationProcessService;

    @Autowired
    public DigitizationProcessController(DigitizationProcessService digitizationProcessService) {
        this.digitizationProcessService = digitizationProcessService;
    }
}
