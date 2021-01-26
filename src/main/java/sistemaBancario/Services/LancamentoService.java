package sistemaBancario.Services;

import java.time.LocalDate;

import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.LancamentoRepository;
import sistemaBancario.repository.PlanoContaRepository;

public class LancamentoService {
	LancamentoRepository lrep = new LancamentoRepository();
	ContaRepository crep = new ContaRepository();
	PlanoContaRepository pcrep = new PlanoContaRepository();
	
	
	public void transferencia(String descricao, int contaOrigem , int contaRecebedora, double valorTransferencia, String finalidade ) {
		
		LocalDate dataTransacao = LocalDate.now();
		Conta origem = crep.findById(contaOrigem);
		Conta recebedora = crep.findById(contaRecebedora);
		if(valorTransferencia >= origem.getSaldo()) {
			throw new ArithmeticException("Saldo Insulficiente");
		}else {
			origem.setSaldo(origem.getSaldo() - valorTransferencia);
			crep.update(origem);
			recebedora.setSaldo(recebedora.getSaldo() + valorTransferencia);
			crep.update(recebedora);
			
		}
		PlanoConta fnl = new PlanoConta();
		fnl.setFinalidade(finalidade);
		pcrep.create(fnl);
		
		Lancamento lanc = new Lancamento();
		lanc.setDescricao(descricao);
		lanc.setDataLancamento(dataTransacao);
		lanc.setValor(valorTransferencia);
		lanc.setContaOrigem(origem);
		lanc.setContaDestino(recebedora);
		lanc.setPlanoConta(fnl);
		lrep.create(lanc);
				
	}
	
	public void pagamento(double valorConta, int conta, String descricao, String finalidade) {
		LocalDate dataTransacao = LocalDate.now();
		ContaService cSer = new ContaService();
		Conta cpagamento = crep.findById(conta);		
		cSer.pagar(cpagamento, valorConta);
		
		PlanoConta fnl = new PlanoConta();
		fnl.setFinalidade(finalidade);
		pcrep.create(fnl);
		
		Lancamento lanc = new Lancamento();
		lanc.setDataLancamento(dataTransacao);
		lanc.setDescricao(descricao);
		lanc.setContaOrigem(cpagamento);
		lanc.setPlanoConta(fnl);
		lanc.setValor(valorConta);
		lrep.create(lanc);
	}
	
	
}
