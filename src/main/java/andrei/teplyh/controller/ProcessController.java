package andrei.teplyh.controller;

import andrei.teplyh.dto.AdvertisingProcessDTO;
import andrei.teplyh.dto.PlotProcessDTO;
import andrei.teplyh.dto.ProcessDTO;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.exceptions.ProductNotFoundException;
import andrei.teplyh.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{productId}")
public class ProcessController {
    private final ProcessService processService;

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @GetMapping
    public ResponseEntity getProcesses(@PathVariable("productId") int productId) {
        try {
            List<ProcessDTO> response = processService.getAllProcesses(productId);
            return ResponseEntity.ok().body(response);
        } catch (NullPointerException | ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping(path = "/create_process", produces = "application/json")
    public ResponseEntity createProcess(
            @RequestParam(name = "productId") int productId,
            @RequestBody ProcessDTO processDTO
    ) {
        int mainWorkerId = processService.createProcess(processDTO, productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(mainWorkerId);
    }

    @GetMapping(path = "/REVISION_PROCESS", produces = "application/json")
    public ResponseEntity getAllRevisionProcesses(
            @PathVariable("productId") int productId,
            @RequestAttribute("login") String login,
            @RequestBody PlotProcessDTO advertisingProcessDTO
    ) {
        processService.createPloProcess(advertisingProcessDTO, productId, login);

        return null;
    }
}
