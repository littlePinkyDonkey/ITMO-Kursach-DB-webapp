package andrei.teplyh.service;

import andrei.teplyh.entity.User;
import andrei.teplyh.entity.enums.*;
import andrei.teplyh.entity.pivot.Plot;
import andrei.teplyh.entity.processes.PlotProcess;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.entity.processes.StoryboardProcess;
import andrei.teplyh.entity.workers.*;
import andrei.teplyh.repository.ArtifactRepository;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.repository.pivot.PlotRepository;
import andrei.teplyh.repository.processes.AdvertisingProcessRepository;
import andrei.teplyh.repository.processes.PlotProcessRepository;
import andrei.teplyh.repository.processes.ProcessRepository;
import andrei.teplyh.repository.processes.StoryboardProcessRepository;
import andrei.teplyh.repository.workers.*;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private StoryboardArtistRepository storyboardArtistRepository;

    @Autowired
    private WorkersRepository workersRepository;

    @Autowired
    private ArtistsRepository artistsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesDesignerRepository rolesDesignerRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private AdvertisingProcessRepository advertisingProcessRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private PlotProcessRepository plotProcessRepository;

    @Autowired
    private RegisseurRepository regisseurRepository;

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private StoryboardProcessRepository storyboardProcessRepository;

    @Override
    @Transactional
    public void showIfWorks() {
//
        Date date = new Date();

//        userRepository.deleteAll();
//        workersRepository.deleteAll();
//        storyboardProcessRepository.deleteAll();
//        artifactRepository.deleteAll();


        int mainWorkerId = workersRepository.addWorker("andrei", "teplyh", "male", 20, "Russia");
        int storyboarderId = storyboardArtistRepository.addExistingStoryboardArtist(mainWorkerId);

        int storyboardProcessId = storyboardProcessRepository.createStoryboardProcess(20, new Timestamp(date.getTime()), "blablabla",
                ProcessStatuses.FINISHED.getDescription(), Timestamp.valueOf("2012-04-10 17:57:08.8"), 20);

        int artifactId = artifactRepository.createArtifact(mainWorkerId, ArtifactTypes.TEXT.getDescription(), 20, new Timestamp(date.getTime()), "~/");

        storyboardProcessRepository.associateStoryboarderAndProcess(storyboarderId, storyboardProcessId);

        int userId = userRepository.addUser(mainWorkerId, "andrei270900", "admin","dasdsa","dsada", date);

        List<StoryboardArtist> artists = storyboardArtistRepository.findAll();
//        int regisseurId = regisseurRepository.addExistingRegisseur(1, 1);
//
//        int plotProcessId = plotProcessRepository.createPlotProcess(12, new Timestamp(date.getTime()),
//                "test", ProcessStatuses.FINISHED.getDescription(), Timestamp.valueOf("2012-04-10 17:57:08.8"));
//
//        plotProcessRepository.associateRegisseurAndPlotProcess(regisseurId, 1);

        User user = userRepository.getUserByLogin("andrei270900");

        List<StoryboardProcess> processes = storyboardProcessRepository.findAll();

        List<PlotProcess> plotProcesses = plotProcessRepository.findAll();
        List<Plot> plots = plotRepository.findAll();
        System.out.println("\ndsadsa");

//        testRepository.test3("stan", AbilityTypes.CHATTING.getDescription());
//        List<Test> tests =  testRepository.test2();
//        tests.forEach(System.out::println);
    }
}
