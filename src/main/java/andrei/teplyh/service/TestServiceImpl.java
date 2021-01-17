package andrei.teplyh.service;

import andrei.teplyh.entity.enums.ProducerRoles;
import andrei.teplyh.entity.pivot.Plot;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.entity.workers.ArtDirector;
import andrei.teplyh.entity.workers.Producer;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.repository.pivot.PlotRepository;
import andrei.teplyh.repository.processes.AdvertisingProcessRepository;
import andrei.teplyh.repository.processes.PlotProcessRepository;
import andrei.teplyh.repository.processes.ProcessRepository;
import andrei.teplyh.repository.workers.*;
import andrei.teplyh.repository.TestRepository;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private StoryboardArtistRepository storyboardArtistRepository;

    @Autowired
    private WorkersRepository workersRepository;

    @Autowired
    private TestRepository testRepository;

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

        plotProcessRepository.findAll().forEach(System.out::println);
        List<Plot> plots = plotRepository.findAll();
        System.out.println("dsadsa");

//        testRepository.test3("stan", AbilityTypes.CHATTING.getDescription());
//        List<Test> tests =  testRepository.test2();
//        tests.forEach(System.out::println);
    }
}
