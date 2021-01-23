package andrei.teplyh.service.impl;

import andrei.teplyh.dto.RegistrationUserDTO;
import andrei.teplyh.entity.User;
import andrei.teplyh.exceptions.UserAlreadyExistsException;
import andrei.teplyh.repository.RolesRepository;
import andrei.teplyh.repository.workers.WorkersRepository;
import andrei.teplyh.service.RegistrationService;
import andrei.teplyh.service.UserService;
import andrei.teplyh.service.WorkerDeterminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;

    private final RolesRepository rolesRepository;

    private final WorkersRepository workersRepository;

    private final WorkerDeterminationService workerDeterminationService;

    @Autowired
    public RegistrationServiceImpl(
            UserService userService,
            RolesRepository rolesRepository,
            WorkersRepository workersRepository,
            WorkerDeterminationService workerDeterminationService
    ) {
        this.userService = userService;
        this.rolesRepository = rolesRepository;
        this.workersRepository = workersRepository;
        this.workerDeterminationService = workerDeterminationService;
    }

    @Override
    public void signUp(RegistrationUserDTO registrationUserDTO) throws UserAlreadyExistsException {
        User user = userService.findUserByLogin(registrationUserDTO.getLogin());
        if (user != null) {
            throw new UserAlreadyExistsException("User already exists");
        }

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
            workerDeterminationService.addWorker(registrationUserDTO.getRoles(), mainWorkerId);
        }
    }
}
