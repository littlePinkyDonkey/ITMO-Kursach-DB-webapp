package andrei.teplyh.dao.repository;

import andrei.teplyh.dao.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Procedure("test")
    List<Test> getAll();
}
