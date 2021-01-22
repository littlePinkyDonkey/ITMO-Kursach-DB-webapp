package andrei.teplyh.service.impl;

import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.repository.RolesRepository;
import andrei.teplyh.repository.workers.WorkersRepository;
import andrei.teplyh.service.RegistrationService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;

    private final RolesRepository rolesRepository;

    private final WorkersRepository workersRepository;
    @Autowired
    public RegistrationServiceImpl(
            UserService userService,
            RolesRepository rolesRepository,
            WorkersRepository workersRepository
    ) {
        this.userService = userService;
        this.rolesRepository = rolesRepository;
        this.workersRepository = workersRepository;
    }

    @Override
    public void signUp(RegistrationUserDTO registrationUserDTO) {
        int mainWorkerId = workersRepository.addWorker(
                registrationUserDTO.getName(),
                registrationUserDTO.getSecondName(),
                registrationUserDTO.getGender(),
                registrationUserDTO.getPlaceOfBirth()
        );
        registrationUserDTO.setWorkerId(mainWorkerId);

        int userId = userService.registerUser(registrationUserDTO);

        if (registrationUserDTO.getRoles() != null) {
            for (String role : registrationUserDTO.getRoles()) {
                rolesRepository.addRoleToUser(userId, role);
            }
        }
    }
}
