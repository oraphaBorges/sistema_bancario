package sistemaBancario.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardResource {

    @GetMapping
    public String getMovimentacao(@RequestParam String dataInicio, String dataFim, String login){
        return "retorno usuario";
    }
}