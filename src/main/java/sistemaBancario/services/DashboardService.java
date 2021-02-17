package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.dto.DashboardDTO;
import sistemaBancario.models.Conta;

@Service
public class DashboardService {

	@Autowired
	private ContaService contaService;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	public ArrayList<DashboardDTO> build(String login, LocalDate inicio, LocalDate fim) {
		if(inicio.compareTo(fim) > 0)
			throw new IllegalStateException();
		ArrayList<Conta> contas = contaService.buscar(login);
		if(contas.isEmpty())
			throw new NullPointerException();
		ArrayList<DashboardDTO> dtos = new ArrayList<DashboardDTO>();
		DashboardDTO dto;
		for(Conta c: contas) {
			dto = new DashboardDTO();
			dto.tipo = c.getSigla();
			dto.saldo = c.getSaldo();
			dto.id = c.getId();
			dto.lancamentos = lancamentoService.getLancamentos(c.getId(),inicio,fim);
			
			dtos.add(dto);
		}
		return dtos;
		
	}
}
