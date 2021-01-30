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
		
		Optional<PlanoConta> optplanoconta = planoContaService.buscar(lancamentoDTO.getContaOrigem());
		PlanoConta planoConta = optplanoconta.get();
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		repository.save(conta);
		
		System.out.println("\n\n"+lancamentoDTO.getValor()+"\n\n");
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				   							 planoConta,lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
	}
	
	public void cadastrar(Usuario usuario, Conta conta) {
		repository.save(conta);
		usuario.addConta(conta);
	}

	public ArrayList<Lancamento> consultarExtrato(ContaDTO conta, LocalDate dataInicio, LocalDate dataFim){
		return lancamentoService.getLancamentosContaPeriodo(conta, dataInicio, dataFim);
	}
	
	public ArrayList<Lancamento> consultarExtrato(Conta conta){
		return lancamentoService.getLancamentosContaAll(conta.getId());
	}

	public Conta buscar(Usuario usuario, Sigla sigla) {
		return repository.findByTitularAndSigla(usuario,sigla);
	}
	
	public Double consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}
	
}
