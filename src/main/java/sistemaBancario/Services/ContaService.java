package sistemaBancario.Services;

import sistemaBancario.models.Conta;

public class ContaService {

	public void pagar(Conta conta, double valor) {
		if (valor > conta.getSaldo()) {
			throw new ArithmeticException("Saldo Insulficiente");
		} else {
			conta.setSaldo(conta.getSaldo() - valor);
		}
	}

	public void depositar(Conta conta, double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
	}
	
	public Double consultarSaldo(Conta conta) {
		return conta.getSaldo();
	}


}
