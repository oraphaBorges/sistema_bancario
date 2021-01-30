package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.dto.ContaDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.Lancamento;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private LancamentoService lancamentoService;

	
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
