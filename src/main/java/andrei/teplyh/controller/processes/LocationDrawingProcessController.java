package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.LocationDrawingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processes/location_drawing_process")
public class LocationDrawingProcessController {
    private final LocationDrawingProcessService locationDrawingProcessService;

    @Autowired
    public LocationDrawingProcessController(LocationDrawingProcessService locationDrawingProcessService) {
        this.locationDrawingProcessService = locationDrawingProcessService;
    }
}
