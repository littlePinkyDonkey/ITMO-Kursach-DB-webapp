package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Digitizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitizerRepository extends JpaRepository<Digitizer, Integer> {
    @Procedure("add_digitizer")
    int addDigitizer(String name, String secondName, String gender, int age, String placeOfBirth);

    @Procedure("add_existing_digitizer")
    int addExistingDigitizer(int mainWorkerId);

    @Procedure("delete_digitizer")
    boolean deleteDigitizer(int mainWorkerId);

    @Procedure("associate_digitizer_and_process")
    boolean associateDigitizerAndProcess(int workerId, int processId);
}