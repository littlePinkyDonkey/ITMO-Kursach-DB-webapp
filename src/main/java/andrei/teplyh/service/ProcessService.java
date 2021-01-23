package andrei.teplyh.service;

import andrei.teplyh.dto.AdvertisingProcessDTO;
import andrei.teplyh.dto.PlotProcessDTO;
import andrei.teplyh.dto.ProcessDTO;
import andrei.teplyh.entity.processes.AdvertisingProcess;
import andrei.teplyh.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProcessService {
    List<ProcessDTO> getAllProcesses(int productId) throws ProductNotFoundException;

    int createProcess(ProcessDTO processDTO, int productId);

    int createPloProcess(PlotProcessDTO processDTO, int productId, String login);
}
