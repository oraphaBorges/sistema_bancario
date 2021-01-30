package sistemaBancario.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sistemaBancario.models.Lancamento;


public interface LancamentoRepository extends CrudRepository<Lancamento,Long> {

	@Query("select u from Lancamento u where contaOrigem.id = :id and u.dataLancamento between :dataInicio and :dataFim")
	public ArrayList<Lancamento> findAllByDataLancamentoBetween (Long id, LocalDate dataInicio, LocalDate dataFim);
   

	public ArrayList<Lancamento> findAllByContaOrigem_id (Long id);
	

}
