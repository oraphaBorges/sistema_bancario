package sistemaBancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
		
	
}
	
	



