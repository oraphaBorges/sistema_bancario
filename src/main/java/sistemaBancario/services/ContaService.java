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
import sistemaBancario.models.Usuario;
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
		Optional<Conta> optconta = repository.findById(lancamentoDTO.getContaOrigem());
		Conta conta = optconta.get();
		
		Optional<PlanoConta> optplanoconta = planoContaService.buscar(lancamentoDTO.getPlanoConta());
		PlanoConta planoConta = optplanoconta.get();
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				   							   planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(conta);
	}
	
	@Transactional
	public void pagar(LancamentoDTO lancamentoDTO) {
		Optional<Conta> optconta = repository.findById(lancamentoDTO.getContaOrigem());
		Conta conta = optconta.get();
		
		Optional<PlanoConta> optplanoconta = planoContaService.buscar(lancamentoDTO.getPlanoConta());
		PlanoConta planoConta = optplanoconta.get();
		
		lancamentoDTO.setValor(lancamentoDTO.getValor()*(-1));
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(conta);
	}
	
	@Transactional
	public void transferir(LancamentoDTO lancamentoDTO) {
		Optional<Conta> optconta;
		optconta = repository.findById(lancamentoDTO.getContaOrigem());
		Conta origem = optconta.get();
		optconta = repository.findById(lancamentoDTO.getContaDestino());
		Conta destino = optconta.get();
		
		Optional<PlanoConta> optplanoconta = planoContaService.buscar(lancamentoDTO.getPlanoConta());
		PlanoConta planoConta = optplanoconta.get();
		
		Lancamento lancamento;
		destino.setSaldo(origem.getSaldo() + lancamentoDTO.getValor());
		lancamento = new Lancamento(destino, lancamentoDTO.getValor(), origem,
									planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		lancamentoDTO.setValor(lancamentoDTO.getValor()*(-1));		
		origem.setSaldo(origem.getSaldo() + lancamentoDTO.getValor());
		
		lancamento = new Lancamento(origem, lancamentoDTO.getValor(), destino,
									planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(origem);
		repository.save(destino);
	}

	public ArrayList<LancamentoDTO> consultarExtratoPorPeriodo(Long id, LocalDate dataInicio, LocalDate dataFim){
		return lancamentoService.getLancamentosContaPeriodo(id, dataInicio, dataFim);
	}
	
	public ArrayList<LancamentoDTO> consultarExtratoPorConta(Long id){
		return lancamentoService.getLancamentosContaAll(id);
	}

	public ContaDTO buscarPorLoginESigla(String login, Sigla sigla) {
		Conta contaBd = repository.findByTitularLoginAndSigla(login,sigla);
		ContaDTO contaDTO = new ContaDTO(contaBd);
		contaDTO.setId(contaBd.getId());

		return contaDTO;
	}
	
	public Double consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}
	
}
