package sistemaBancario.Services;

import sistemaBancario.models.Conta;
import sistemaBancario.repository.ContaRepository;

public class ContaService {

	private ContaRepository rep = new ContaRepository();
	
	public void pagar(Conta conta, double valor) {
		if (valor > conta.getSaldo()) {
			throw new ArithmeticException("Saldo Insulficiente");
		} else {
			conta.setSaldo(conta.getSaldo() - valor);
			rep.update(conta);
		}
	}

	public void depositar(Conta conta, double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		rep.update(conta);
	}
	
	public Double consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}


}
