package andrei.teplyh.service;

import andrei.teplyh.repository.workers.ArtistsRepository;
import andrei.teplyh.repository.workers.StoryboardArtistRepository;
import andrei.teplyh.repository.TestRepository;
import andrei.teplyh.repository.workers.WorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void showIfWorks() {
//        workersRepository.findAll().forEach(System.out::println);
//        System.out.println("************************");
//        storyboardArtistRepository.findAll().forEach(System.out::println);
//        testRepository.test2().forEach(System.out::println);

        artistsRepository.findAll().forEach(System.out::println);

//        testRepository.test3("stan", AbilityTypes.CHATTING.getDescription());
//        List<Test> tests =  testRepository.test2();
//        tests.forEach(System.out::println);
    }
}
