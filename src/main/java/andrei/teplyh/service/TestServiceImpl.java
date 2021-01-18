package andrei.teplyh.service;

import andrei.teplyh.entity.Artifact;
import andrei.teplyh.entity.enums.ArtifactTypes;
import andrei.teplyh.entity.enums.ProducerRoles;
import andrei.teplyh.entity.pivot.Plot;
import andrei.teplyh.entity.processes.PlotProcess;
import andrei.teplyh.entity.processes.Process;
import andrei.teplyh.entity.workers.ArtDirector;
import andrei.teplyh.entity.workers.Producer;
import andrei.teplyh.entity.workers.Regisseur;
import andrei.teplyh.entity.workers.Worker;
import andrei.teplyh.repository.ArtifactRepository;
import andrei.teplyh.repository.UserRepository;
import andrei.teplyh.repository.pivot.PlotRepository;
import andrei.teplyh.repository.processes.AdvertisingProcessRepository;
import andrei.teplyh.repository.processes.PlotProcessRepository;
import andrei.teplyh.repository.processes.ProcessRepository;
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

//        String[] array = {"good", "bad"};
//
//        Regisseur regisseur = new Regisseur();
//        regisseur.setName("andrey");
//        regisseur.setSecondName("teplyh");
//        regisseur.setGender("male");
//        regisseur.setAge(20);
//        regisseur.setBirthPlace("russia");
//        regisseur.setFilmsNumber(2);
//        regisseur.setGenres(array);
//        regisseurRepository.addRegisseur(regisseur.getName(), regisseur.getSecondName(), regisseur.getGender(), regisseur.getAge(),
//                regisseur.getBirthPlace(), regisseur.getFilmsNumber(), regisseur.getGenres());

        List<Worker> workers = workersRepository.findAll();
//        List<Artifact> artifacts = artifactRepository.findAll();

        List<PlotProcess> plotProcesses = plotProcessRepository.findAll();
        List<Plot> plots = plotRepository.findAll();
        System.out.println("dsadsa");

//        testRepository.test3("stan", AbilityTypes.CHATTING.getDescription());
//        List<Test> tests =  testRepository.test2();
//        tests.forEach(System.out::println);
    }
}
