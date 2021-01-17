package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.RolesDesigner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDesignerRepository extends JpaRepository<RolesDesigner, Integer> {
    @Procedure("add_roles_designer")
    boolean addRolesDesigner(String name, String secondName, String gender, int age, String placeOfBirth);

    @Procedure("add_existing_roles_designer")
    boolean addExistingRolesDesigner(int mainWorkerId);

    @Procedure("delete_roles_designer")
    boolean deleteRolesDesigner(int mainWorkerId);
}
