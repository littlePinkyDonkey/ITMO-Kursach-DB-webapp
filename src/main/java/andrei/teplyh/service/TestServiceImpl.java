package andrei.teplyh.service;

import andrei.teplyh.dao.entity.Test;
import andrei.teplyh.dao.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
//    @Autowired
//    private StoryboardArtistRepository storyboardArtistRepository;
//
//    @Autowired
//    private WorkersRepository workersRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    @Transactional
    public void showIfWorks() {
        List<Test> list = testRepository.getAll();
        list.get(0);
//        testRepository.getAll().forEach(System.out::println);
//        workersRepository.findAll().forEach(System.out::println);
//        System.out.println("************************");
//        storyboardArtistRepository.findAll().forEach(System.out::println);
    }
}
