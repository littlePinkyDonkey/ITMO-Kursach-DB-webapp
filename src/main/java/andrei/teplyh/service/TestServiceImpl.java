package andrei.teplyh.service;

import andrei.teplyh.dao.entity.StoryboardArtist;
import andrei.teplyh.dao.entity.Test;
import andrei.teplyh.dao.repository.StoryboardArtistRepository;
import andrei.teplyh.dao.repository.TestRepository;
import andrei.teplyh.dao.repository.WorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private StoryboardArtistRepository storyboardArtistRepository;

    @Autowired
    private WorkersRepository workersRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    @Transactional
    public void showIfWorks() {
//        testRepository.findAll().forEach(System.out::println);
//        testRepository.getAll().forEach(System.out::println);
//        workersRepository.findAll().forEach(System.out::println);
//        System.out.println("************************");
//        storyboardArtistRepository.findAll().forEach(System.out::println);
        testRepository.test("olya");
        testRepository.test2().forEach(System.out::println);
    }
}
