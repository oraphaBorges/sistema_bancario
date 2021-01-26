package sistemaBancario.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Query;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;

public class LancamentoRepository extends RepositoryGeneric<Lancamento> {

	public Lancamento findById(Integer id) {
		return em.find(Lancamento.class, id);
	}

	public ArrayList<Lancamento> getLancamentosPeriodo(Conta conta, LocalDate dataInicio, LocalDate dataFim) {
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
	}
}
