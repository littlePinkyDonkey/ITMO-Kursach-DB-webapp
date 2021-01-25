package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.VoiceActingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/voice_acting_process")
public class VoiceActingProcessController {
    private final VoiceActingProcessService voiceActingProcessService;

    @Autowired
    public VoiceActingProcessController(VoiceActingProcessService voiceActingProcessService) {
        this.voiceActingProcessService = voiceActingProcessService;
    }
}
