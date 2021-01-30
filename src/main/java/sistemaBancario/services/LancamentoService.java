package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.dto.ContaDTO;
import sistemaBancario.models.Lancamento;
import sistemaBancario.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;

	public void realizarLancamento(Lancamento lancamento) {
		repository.save(lancamento);
	}

	public ArrayList<Lancamento> getLancamentosContaPeriodo(ContaDTO conta, LocalDate dataInicio, LocalDate dataFim) {
		return repository.findAllByDataLancamentoBetween(conta.getId(), dataInicio, dataFim); 
	}
	public ArrayList<Lancamento> getLancamentosContaAll(Long contaId) {
		return repository.findAllByContaOrigem_id(contaId); 
	}

}
