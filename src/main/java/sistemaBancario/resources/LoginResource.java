package sistemaBancario.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}