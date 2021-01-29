package andrei.teplyh.service.workers;

import andrei.teplyh.entity.workers.RolesDesigner;

import java.util.List;

public interface RolesDesignerService {
    List<RolesDesigner> findAll();

    int addRolesDesigner(String name, String secondName, String gender, String placeOfBirth);

    int addExistingRolesDesigner(int mainWorkerId);

    boolean deleteRolesDesigner(int mainWorkerId);

    boolean associateDesignerAndAbilityProcess(int workerId, int processId);

    boolean associateDesignerAndCharacterProcess(int workerId, int processId);
}
