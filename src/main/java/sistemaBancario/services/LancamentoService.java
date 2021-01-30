package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import sistemaBancario.models.Conta;
import sistemaBancario.dto.ContaDTO;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.LancamentoRepository;

public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;

	public void realizarLancamento(Conta origem, Conta destino, double valor, PlanoConta finalidade, String descricao) {
		try {
			LocalDate dataTransacao = LocalDate.now();
			Lancamento lancamento = new Lancamento();
			lancamento.setContaOrigem(origem);
			lancamento.setValor(valor);
			lancamento.setContaDestino(destino);
			lancamento.setPlanoConta(finalidade);
			lancamento.setDataLancamento(dataTransacao);
			lancamento.setDescricao(descricao);
			repository.save(lancamento);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Lancamento> getLancamentosContaPeriodo(ContaDTO conta, LocalDate dataInicio, LocalDate dataFim) {
		return repository.findAllByDataLancamentoBetween(conta.getId(), dataInicio, dataFim); 
	}
	public ArrayList<Lancamento> getLancamentosContaAll(Long contaId) {
		return repository.findAllByContaOrigem_id(contaId); 
	}

}
