package andrei.teplyh.service.impl.workers;

import andrei.teplyh.entity.workers.RolesDesigner;
import andrei.teplyh.repository.workers.RolesDesignerRepository;
import andrei.teplyh.service.workers.RolesDesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesDesignerServiceImpl implements RolesDesignerService {
    private final RolesDesignerRepository rolesDesignerRepository;

    @Autowired
    public RolesDesignerServiceImpl(RolesDesignerRepository rolesDesignerRepository) {
        this.rolesDesignerRepository = rolesDesignerRepository;
    }

    @Override
    public List<RolesDesigner> findAll() {
        return null;
    }

    @Override
    public int addRolesDesigner(String name, String secondName, String gender, String placeOfBirth) {
        return 0;
    }

    @Override
    public int addExistingRolesDesigner(int mainWorkerId) {
        return rolesDesignerRepository.addExistingRolesDesigner(mainWorkerId);
    }

    @Override
    public boolean deleteRolesDesigner(int mainWorkerId) {
        return false;
    }

    @Override
    public boolean associateDesignerAndAbilityProcess(int workerId, int processId) {
        return false;
    }

    @Override
    public boolean associateDesignerAndCharacterProcess(int workerId, int processId) {
        return false;
    }
}
