package sistemaBancario.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
		
	Conta findByTitularLoginAndSigla(String login, Sigla sigla);

	ArrayList<Conta> findAllByTitularLogin(String login);
}
	
	



