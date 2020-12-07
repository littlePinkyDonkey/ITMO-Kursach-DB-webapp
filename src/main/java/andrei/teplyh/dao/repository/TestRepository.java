package andrei.teplyh.dao.repository;

import andrei.teplyh.dao.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    @Procedure("test")
    boolean test(String name);

    @Query(value = "select * from test2()", nativeQuery = true)
    List<Test> test2();
}
