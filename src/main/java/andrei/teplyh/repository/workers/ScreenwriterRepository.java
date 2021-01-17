package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.Screenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenwriterRepository extends JpaRepository<Screenwriter, Integer> {
    @Procedure("add_screenwriter")
    boolean addScreenwriter(String name, String secondName, String gender, int age, String placeOfBirth,
                            int filmsNumber, String[] genres);

    @Procedure("add_existing_screenwriter")
    boolean addExistingScreenwriter(int mainWorkerId, int filmsNumber, String[] genres);

    @Procedure("delete_screenwriter")
    boolean deleteScreenwriter(int mainWorkerId);
}
