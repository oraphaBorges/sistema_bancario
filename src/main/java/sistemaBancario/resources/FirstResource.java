package sistemaBancario.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstResource {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
