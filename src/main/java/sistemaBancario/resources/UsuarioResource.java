package sistemaBancario.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}