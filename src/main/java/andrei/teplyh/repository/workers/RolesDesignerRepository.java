package andrei.teplyh.repository.workers;

import andrei.teplyh.entity.workers.RolesDesigner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDesignerRepository extends JpaRepository<RolesDesigner, Integer> {
    @Procedure("add_roles_designer")
    int addRolesDesigner(String name, String secondName, String gender, String placeOfBirth);

    @Procedure("add_existing_roles_designer")
    int addExistingRolesDesigner(int mainWorkerId);

    @Procedure("delete_roles_designer")
    boolean deleteRolesDesigner(int mainWorkerId);

    @Procedure("associate_designer_and_ability_process")
    boolean associateDesignerAndAbilityProcess(int workerId, int processId);

    @Procedure("associate_designer_and_character_process")
    boolean associateDesignerAndCharacterProcess(int workerId, int processId);
}
