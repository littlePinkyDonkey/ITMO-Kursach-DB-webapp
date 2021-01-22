package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
    @Procedure("add_producer")
    int addProducer(String name, String secondName, String gender, String placeOfBirth, String role);

    @Procedure("add_existing_producer")
    int addExistingProducer(int mainWorkerId, String role);

    @Procedure("delete_producer")
    boolean deleteProducer(int mainWorkerId);

    @Procedure("associate_producer_and_process")
    boolean associateProducerAndProcess(int workerId, int processId);
}
