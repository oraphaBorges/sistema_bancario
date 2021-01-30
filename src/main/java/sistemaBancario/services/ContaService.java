package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;

public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private LancamentoService lancamentoService;

	public void pagar(Conta conta, double valor, PlanoConta finalidade, String descricao) {
		if (valor > conta.getSaldo())
			throw new ArithmeticException("Saldo Insulficiente");

		conta.setSaldo(conta.getSaldo() - valor);
		repository.save(conta);
		lancamentoService.realizarLancamento(conta, null, valor, finalidade, descricao);

	}

	public void transferir(Conta origem, double valor, Conta destino, PlanoConta finalidade, String descricao) {
		if (valor > origem.getSaldo())
			throw new ArithmeticException("Saldo Insulficiente");

		origem.setSaldo(origem.getSaldo() - valor);
		repository.save(origem);
		destino.setSaldo(destino.getSaldo() + valor);
		repository.save(destino);
		lancamentoService.realizarLancamento(origem, destino, valor, finalidade, descricao);

	}

	public void depositar(Conta conta, double valor, String descricao) {
		conta.setSaldo(conta.getSaldo() + valor);
		repository.save(conta);
		lancamentoService.realizarLancamento(conta, null, valor, null, descricao);
	}

	public Double consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}

	public void cadastrar(Usuario usuario, Conta conta) {
		repository.save(conta);
		usuario.addConta(conta);
	}

	public ArrayList<Lancamento> consultarExtrato(Conta conta, LocalDate dataInicio, LocalDate dataFim){
		return lancamentoService.getLancamentosContaPeriodo(conta, dataInicio, dataFim);
	}
	public ArrayList<Lancamento> consultarExtrato(Conta conta){
		return lancamentoService.getLancamentosContaAll(conta);
	}

}
