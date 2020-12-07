package andrei.teplyh.controller;

import andrei.teplyh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MainController {
    @Autowired
    private TestService testService;

    @GetMapping(path = "/a", produces = "application/json")
    public String test() {
        testService.showIfWorks();
        return "a";
    }

    @GetMapping
    public String test2() {
        return "b";
    }
}
