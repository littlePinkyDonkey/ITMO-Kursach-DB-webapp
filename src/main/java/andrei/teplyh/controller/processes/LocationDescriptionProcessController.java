package andrei.teplyh.controller.processes;

import andrei.teplyh.service.processes.LocationDescriptionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location_description_process")
public class LocationDescriptionProcessController {
    private final LocationDescriptionProcessService locationDescriptionProcessService;

    @Autowired
    public LocationDescriptionProcessController(LocationDescriptionProcessService locationDescriptionProcessService) {
        this.locationDescriptionProcessService = locationDescriptionProcessService;
    }
}
