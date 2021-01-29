package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.Producer;
import andrei.teplyh.repository.workers.ProducerRepository;
import andrei.teplyh.service.workers.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> findAll() {
        return null;
    }

    @Override
    public int addProducer(String name, String secondName, String gender, String placeOfBirth, String role) {
        return 0;
    }

    @Override
    public int addExistingProducer(int mainWorkerId, String role) {
        return producerRepository.addExistingProducer(mainWorkerId, role);
    }

    @Override
    public boolean deleteProducer(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateProducerAndProcess(int workerId, int processId) {
        return false;
    }
}
