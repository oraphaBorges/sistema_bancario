package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemaBancario.dto.ContaDTO;
import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private PlanoContaService planoContaService;

	@Transactional
	public void depositar(LancamentoDTO lancamentoDTO) {
		Conta conta = buscar(lancamentoDTO.getContaOrigem().login,lancamentoDTO.getContaOrigem().sigla);

		PlanoConta planoConta = planoContaService.buscar(lancamentoDTO.getPlanoConta(),lancamentoDTO.getContaOrigem().login);
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				   							   planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(conta);
	}
	
	@Transactional
	public void pagar(LancamentoDTO lancamentoDTO) {
		Conta conta = buscar(lancamentoDTO.getContaOrigem().login,lancamentoDTO.getContaOrigem().sigla);
		
		PlanoConta planoConta = planoContaService.buscar(lancamentoDTO.getPlanoConta(),lancamentoDTO.getContaOrigem().login);
		
		lancamentoDTO.setValor(lancamentoDTO.getValor()*(-1));
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(conta);
	}
	
	@Transactional
	public void transferir(LancamentoDTO lancamentoDTO) {
		Conta origem = buscar(lancamentoDTO.getContaOrigem().login,lancamentoDTO.getContaOrigem().sigla);
		Conta destino = buscar(lancamentoDTO.getContaDestino().login,lancamentoDTO.getContaDestino().sigla);

		PlanoConta planoConta = planoContaService.buscar(lancamentoDTO.getPlanoConta(),lancamentoDTO.getContaOrigem().login);
		
		Lancamento lancamento;
		// Registro da saída da conta de origem
		destino.setSaldo(origem.getSaldo() + lancamentoDTO.getValor());
		lancamento = new Lancamento(destino, lancamentoDTO.getValor(), origem,
									planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		
		// Registro da entada da conta de destino
		lancamentoDTO.setValor(lancamentoDTO.getValor()*(-1));		
		origem.setSaldo(origem.getSaldo() + lancamentoDTO.getValor());
		lancamento = new Lancamento(origem, lancamentoDTO.getValor(), destino,
									planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		
		// Atualização das Contas
		repository.save(origem);
		repository.save(destino);
	}
	
	public ArrayList<LancamentoDTO> consultarExtrato(String login, Sigla sigla, LocalDate dataInicio, LocalDate dataFim){
		Long idConta = buscar(login, sigla).getId();

		return lancamentoService.getLancamentosContaPeriodo(idConta, dataInicio, dataFim);
	}
	
	public ArrayList<LancamentoDTO> consultarExtrato(String login, Sigla sigla){
		Long idConta = buscar(login, sigla).getId();

		return lancamentoService.getLancamentosContaAll(idConta);
	}
	
	public Double consultarSaldo(ContaDTO contaDTO) {
		Conta conta = buscar(contaDTO.getId());
		return conta.getSaldo();
	}

	public Conta buscar(String login, Sigla sigla) {
		Conta conta = repository.findByTitularLoginAndSigla(login,sigla);
		return conta;
	}
	
	public Conta buscar(Long id) {
		Optional<Conta> optconta;
		optconta = repository.findById(id);
		return optconta.get();
	}
	
}
