package sistemaBancario.repository;

import org.springframework.data.repository.CrudRepository;

import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Usuario;

public interface ContaRepository extends CrudRepository<Conta, Long> {
		
	Conta findByTitularLoginAndSigla(String login, Sigla sigla);
}
	
	



