package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
    @Procedure("add_producer")
    boolean addProducer(String name, String secondName, String gender, int age, String placeOfBirth, String role);

    @Procedure("add_existing_producer")
    boolean addExistingProducer(int mainWorkerId, String role);

    @Procedure("delete_producer")
    boolean deleteProducer(int mainWorkerId);
}
