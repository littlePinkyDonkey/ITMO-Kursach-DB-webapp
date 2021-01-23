package andrei.teplyh.service.impl;

import andrei.teplyh.dto.ProcessDTO;
import andrei.teplyh.entity.Product;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.exceptions.ProductNotFoundException;
import andrei.teplyh.repository.ProductRepository;
import andrei.teplyh.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProcessServiceImpl implements ProcessService {
    private final ProductRepository productRepository;

    @Autowired
    public ProcessServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
}
