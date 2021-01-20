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
        //workersRepository.findAll().forEach(System.out::println);
//        System.out.println("************************");
//        storyboardArtistRepository.findAll().forEach(System.out::println);

//        artistsRepository.findAll().forEach(System.out::println);
        //storyboardArtistRepository.findAll().forEach(System.out::println);
        //rolesDesignerRepository.findAll().forEach(System.out::println);
        //producerRepository.findAll().forEach(System.out::println);
//        userRepository.findAll().forEach(System.out::println);
        //processRepository.findAll().forEach(System.out::println);
//        boolean test =
//                producerRepository.addExistingProducer(12, ProducerRoles.ASSOCIATE_PRODUCER.getDescription());
//        System.out.println(test);
//        advertisingProcessRepository.findAll().forEach(System.out::println);

//        workersRepository.addWorker("andrey", "teplyh", "male", 20, "russia");
//
        Date date = new Date();

        userRepository.deleteAll();
        workersRepository.deleteAll();
        storyboardProcessRepository.deleteAll();
        artifactRepository.deleteAll();

        //userRepository.addUser(1, "andrei", "admin","dasdsa","dsada", date);

//        plotProcessRepository.createPlotProcess(12, new Timestamp(date.getTime()), "dadas",
//                ProcessStatuses.FINISHED.getDescription(), Timestamp.valueOf("2012-04-10 17:57:08.8"));
        int workerId = workersRepository.addWorker("andrei", "teplyh", "male", 20, "Russia");
        int storyboarderId = storyboardArtistRepository.addExistingStoryboardArtist(workerId);

        storyboardProcessRepository.createStoryboardProcess(20, new Timestamp(date.getTime()), "blablabla",
                ProcessStatuses.FINISHED.getDescription(), Timestamp.valueOf("2012-04-10 17:57:08.8"), 20);

        int artifactId = artifactRepository.createArtifact(workerId, ArtifactTypes.TEXT.getDescription(), 20, new Timestamp(date.getTime()), "~/");



        int userId = userRepository.addUser(workerId, "andrei", "admin","dasdsa","dsada", date);

        User user = userRepository.getUserByLogin("andrei");

        List<PlotProcess> plotProcesses = plotProcessRepository.findAll();
        List<Plot> plots = plotRepository.findAll();
        System.out.println("\ndsadsa");

//        testRepository.test3("stan", AbilityTypes.CHATTING.getDescription());
//        List<Test> tests =  testRepository.test2();
//        tests.forEach(System.out::println);
    }
}
