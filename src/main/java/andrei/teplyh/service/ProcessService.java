package andrei.teplyh.service;

import andrei.teplyh.dto.ProcessDTO;
import andrei.teplyh.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProcessService {
    List<ProcessDTO> getAllProcesses(int productId) throws ProductNotFoundException;
}
