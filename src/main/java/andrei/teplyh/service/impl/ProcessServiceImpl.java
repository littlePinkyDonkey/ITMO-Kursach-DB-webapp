package andrei.teplyh.service.impl;

import andrei.teplyh.dto.AdvertisingProcessDTO;
import andrei.teplyh.dto.PlotProcessDTO;
import andrei.teplyh.dto.ProcessDTO;
import andrei.teplyh.entity.Product;
import andrei.teplyh.entity.processes.*;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.exceptions.ProductNotFoundException;
import andrei.teplyh.exceptions.processes.ProcessesUniqueException;
import andrei.teplyh.repository.ProductRepository;
import andrei.teplyh.repository.processes.*;
import andrei.teplyh.service.ProcessService;
import andrei.teplyh.service.RegisseurService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProcessServiceImpl implements ProcessService {
    private final ProductRepository productRepository;
    private final ProcessRepository processRepository;
    private final PlotProcessRepository plotProcessRepository;
    private final RegisseurService regisseurService;

    private final UserService userService;

    @Autowired
    public ProcessServiceImpl(ProductRepository productRepository, ProcessRepository processRepository, PlotProcessRepository plotProcessRepository, RegisseurService regisseurService, UserService userService) {
        this.productRepository = productRepository;
        this.processRepository = processRepository;
        this.plotProcessRepository = plotProcessRepository;
        this.regisseurService = regisseurService;
        this.userService = userService;
    }

    public List<ProcessDTO> getAllProcesses(int productId) throws ProductNotFoundException {
        Product product = productRepository.findProductByProductId(productId);

        if (product == null) {
            throw new ProductNotFoundException(String.format("Product %d does not exist", productId));
        }

        List<Process> processes = product.getProcesses();

        if (processes.size() == 0) {
            throw new NullPointerException(String.format("Product %d: %s has no processes.", productId, product.getProductName()));
        }

        return processes.stream()
                .map(
                        process -> new ProcessDTO(
                                process.getMainProcessId(),
                                process.getDuration(),
                                process.getDeadlineDate(),
                                process.getDescription(),
                                process.getStatus().getDescription(),
                                process.getStartDate()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public int createProcess(ProcessDTO processDTO, int productId) {
        int mainProcessId = processRepository.createProcess(
                productId,
                processDTO.getDuration(),
                processDTO.getDeadlineDate(),
                processDTO.getDescription(),
                processDTO.getProcessStatus(),
                processDTO.getStartDate()
        );

        return mainProcessId;
    }

    @Override
    public int createPloProcess(PlotProcessDTO processDTO, int productId, String login) {
        int processId = plotProcessRepository.createPlotProcess(
                productId,
                processDTO.getDuration(),
                processDTO.getDeadlineDate(),
                processDTO.getDescription(),
                processDTO.getProcessStatus(),
                processDTO.getStartDate());


        int regisseurId = regisseurService.findRegisseurByLogin(login);

        plotProcessRepository.associateRegisseurAndPlotProcess(regisseurId, processId);

        return 0;
    }
}
