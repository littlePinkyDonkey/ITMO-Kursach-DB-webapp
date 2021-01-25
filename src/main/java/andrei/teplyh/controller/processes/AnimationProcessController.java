package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.AnimationProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
@RequestMapping("/api/animation_process")
public class AnimationProcessController {
    private final AnimationProcessService animationProcessService;

    @Autowired
    public AnimationProcessController(AnimationProcessService animationProcessService) {
        this.animationProcessService = animationProcessService;
    }
}
