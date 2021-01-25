package sistemaBancario.repository;

import java.sql.PreparedStatement;

import sistemaBancario.Services.ContaService;
import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Conta;

public class ContaRepository extends RepositoryGeneric<Conta> {
		
	public Conta findById(Integer id) {
		return em.find(Conta.class, id);
	}
	
	
}


