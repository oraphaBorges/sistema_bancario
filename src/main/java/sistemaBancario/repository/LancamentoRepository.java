package sistemaBancario.repository;

import sistemaBancario.generics.RepositoryGeneric;
import sistemaBancario.models.Lancamento;

public class LancamentoRepository extends RepositoryGeneric<Lancamento> {

	public Lancamento findById(Integer id) {
		return em.find(Lancamento.class, id);
	}
}
