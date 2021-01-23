package andrei.teplyh.service.impl;

import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.repository.workers.RegisseurRepository;
import andrei.teplyh.service.RegisseurService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisseurServiceImpl implements RegisseurService {
    private final RegisseurRepository regisseurRepository;
    private final UserService userService;

    @Autowired
    public RegisseurServiceImpl(RegisseurRepository regisseurRepository,
                                UserService userService) {
        this.regisseurRepository = regisseurRepository;
        this.userService = userService;
    }

    @Override
    public int findRegisseurByLogin(String login) {
        int mainWorkerId = userService.findUserByLogin(login).getWorker().getMainWorkerId();
        return regisseurRepository.findRegisseurByMainWorkerId(mainWorkerId).getWorkerId();
    }
}
