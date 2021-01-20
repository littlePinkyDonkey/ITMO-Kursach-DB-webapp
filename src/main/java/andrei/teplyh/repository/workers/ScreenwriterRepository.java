package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Screenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenwriterRepository extends JpaRepository<Screenwriter, Integer> {
    @Procedure("add_screenwriter")
    int addScreenwriter(String name, String secondName, String gender, int age, String placeOfBirth,
                            int filmsNumber);

    @Procedure("add_existing_screenwriter")
    int addExistingScreenwriter(int mainWorkerId, int filmsNumber);

    @Procedure("delete_screenwriter")
    boolean deleteScreenwriter(int mainWorkerId);

    @Procedure("associate_screenwriter_and_battle_process")
    boolean associateScreenwriterAndBattleProcess(int workerId, int processId);

    @Procedure("associate_screenwriter_and_plot_process")
    boolean associateScreenwriterAndPlotProcess(int workerId, int processId);
}
