package andrei.teplyh.dao.repository;

import andrei.teplyh.dao.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Long> {
    @Query("select * from test(:name)")
    boolean add(@Param("name") String name);
}
