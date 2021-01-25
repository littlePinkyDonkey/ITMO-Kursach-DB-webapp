package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.AdvertisingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertising_process")
public class AdvertisingProcessController {
    private final AdvertisingProcessService advertisingProcessService;

    @Autowired
    public AdvertisingProcessController(AdvertisingProcessService advertisingProcessService) {
        this.advertisingProcessService = advertisingProcessService;
    }
}
