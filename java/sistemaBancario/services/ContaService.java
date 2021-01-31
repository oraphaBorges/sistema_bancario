package sistemaBancario.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.PlanoContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	@Autowired
	private PlanoContaRepository planoContaRepository;
	@Autowired
	private LancamentoService lancamentoService;
	@Autowired
	private UsuarioService UsuarioService;

	@Transactional
	public void pagar(LancamentoDTO lancamentoDTO) {
		Optional<Conta> optconta = repository.findById(lancamentoDTO.getContaOrigem());
//		Optional<PlanoConta> optplanoconta = planoContaRepository.findById(lancamentoDTO.getPlanoConta());
		
		Conta conta = optconta.get();
		System.out.println(conta.getId());
//		PlanoConta planoConta = optplanoconta.get();
//		System.out.println(conta.getId());
		
		if (lancamentoDTO.getValor() > conta.getSaldo())
			throw new ArithmeticException("Saldo Insulficiente");

		lancamentoDTO.setValor(lancamentoDTO.getValor()*(-1)); 
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		
		Lancamento lancamento = new Lancamento(conta,lancamentoDTO.getValor(),conta,
											   new PlanoConta("PAGAMENTO"),lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
		repository.save(conta);

	}

	@Transactional
	public void depositar(LancamentoDTO lancamentoDTO) {
		Optional<Conta> optconta = repository.findById(lancamentoDTO.getContaOrigem());
		Conta conta = optconta.get();
		
		conta.setSaldo(conta.getSaldo() + lancamentoDTO.getValor());
		repository.save(conta);
		
		System.out.println("\n\n"+lancamentoDTO.getValor()+"\n\n");
		Lancamento lancamento = new Lancamento(conta, lancamentoDTO.getValor(), conta,
				   							  new PlanoConta("PAGAMENTO"),lancamentoDTO.getDescricao());
		lancamentoService.realizarLancamento(lancamento);
	}
//
//	public void transferir(Conta origem, double valor, Conta destino, PlanoConta finalidade, String descricao) {
//		if (valor > origem.getSaldo())
//			throw new ArithmeticException("Saldo Insulficiente");
//
//		origem.setSaldo(origem.getSaldo() - valor);
//		repository.update(origem);
//		destino.setSaldo(destino.getSaldo() + valor);
//		repository.update(destino);
//		lancamentoService.realizarLancamento(origem, destino, valor, finalidade, descricao);
//
//	}
//
//
//	public Double consultarSaldo(Conta conta) {
//		return conta.getSaldo();
//	}
//

	public void cadastrar(Conta conta) {
		repository.save(conta);
	}
//
//	public ArrayList<Lancamento> consultarExtrato(Conta conta, LocalDate dataInicio, LocalDate dataFim){
//		return lancamentoService.getLancamentosContaPeriodo(conta, dataInicio, dataFim);
//	}
//	public ArrayList<Lancamento> consultarExtrato(Conta conta){
//		return lancamentoService.getLancamentosContaAll(conta);
//	}

	public Conta buscar(Usuario usuario, Sigla sigla) {
		return repository.findByTitularAndSigla(usuario,sigla);
	}

}
