package sistemaBancario.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;

@Repository
public interface LancamentoRepository extends CrudRepository<Lancamento,Long> {


/*
 *  VERIFICAR SE AINDA SERA UTILIZADO ESSE METODO
 *  
 *  	public ArrayList<Lancamento> getLancamentosPeriodo(Conta conta, LocalDate dataInicio, LocalDate dataFim) {
		Query query = em.createQuery("select u from Lancamento u where "
										+ "contaOrigem_id = :conta and "
										+ "u.dataLancamento between "
										+ ":dataInicio "
										+ "and "
										+ ":dataFim"); // JPQL
		query.setParameter("conta", conta.getId());
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		
		return (ArrayList<Lancamento>) query.getResultList();
	}
	public ArrayList<Lancamento> getLancamentosAll(Conta conta) {
		Query query = em.createQuery("select u from Lancamento u "
				+ "where contaOrigem_id = :conta");// JPQL
		query.setParameter("conta", conta.getId());
		
		return (ArrayList<Lancamento>) query.getResultList();
	
 *  }
 */
	
	

}
