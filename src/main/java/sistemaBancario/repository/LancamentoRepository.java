package sistemaBancario.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sistemaBancario.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento,Long> {

	@Query("select u from Lancamento u where contaOrigem.id = :id and u.dataLancamento between :dataInicio and :dataFim")
	public List<Lancamento> findAllByDataLancamentoBetween (Long id, LocalDate dataInicio, LocalDate dataFim);
   

	public List<Lancamento> findAllByContaOrigem_id (Long id);
	

}
