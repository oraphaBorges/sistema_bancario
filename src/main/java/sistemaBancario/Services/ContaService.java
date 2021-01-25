package sistemaBancario.Services;

import java.time.LocalDate;

import sistemaBancario.models.Conta;

public class ContaService {
			
	public double pagamento(String nomePagamento, double valorPagamento, Conta conta) {
		LocalDate transacao = null ;
		
		 if(valorPagamento > conta.getSaldo()) {		
				System.out.println("saldo insulficiente");
				}else {
					 conta.setSaldo(conta.getSaldo() - valorPagamento); 
					 
					 System.out.println("Seu saldo atual é " + conta.getSaldo() + " Data data transação " + transacao.now());
					 
				}		 
		 return conta.getSaldo();
	}
	
	public void consultarSaldo (Conta conta) {		
		System.out.println("O saldo atual da tua conta é" + conta.getSaldo());
	}
	
	public void depositar(Conta conta, double deposito) {
		LocalDate dataDeposito = null ;
		conta.setSaldo(conta.getSaldo() + deposito);
		System.out.println("Você depositou" + deposito + "\n O teu saldo atual é :" + conta.getSaldo());
		System.out.println("Data deposito :" + dataDeposito.now());
	}	
	
}

