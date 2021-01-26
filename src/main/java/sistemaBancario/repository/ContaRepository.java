package sistemaBancario.repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Conta;

public class ContaRepository extends RepositoryGeneric<Conta> {
		
	public Conta findById(Integer id) {
		return em.find(Conta.class, id);
	}
	
	
}


