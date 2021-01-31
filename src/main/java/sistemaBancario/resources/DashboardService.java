package sistemaBancario.resources;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.dto.DashboardDTO;
import sistemaBancario.models.Conta;
import sistemaBancario.services.ContaService;
import sistemaBancario.services.LancamentoService;

@Service
public class DashboardService {

	@Autowired
	private ContaService contaService;
	
	@Autowired
	private LancamentoService lancamentoService;
	
	public ArrayList<DashboardDTO> build(String login, LocalDate inicio, LocalDate fim) {
		ArrayList<Conta> contas = contaService.buscar(login);
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
