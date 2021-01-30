package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistemaBancario.models.Lancamento;
import sistemaBancario.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	public void realizarLancamento(Lancamento lancamento) {
		repository.save(lancamento);
	}

//	public ArrayList<Lancamento> getLancamentosContaPeriodo(Conta conta, LocalDate dataInicio, LocalDate dataFim) {
//		return repository.getLancamentosPeriodo(conta, dataInicio, dataFim); 
//	}
//	public ArrayList<Lancamento> getLancamentosContaAll(Conta conta) {
//		return repository.getLancamentosAll(conta); 
//	}

}
