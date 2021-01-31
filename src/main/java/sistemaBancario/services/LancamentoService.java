package sistemaBancario.services;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaBancario.dto.ContaSimplesDTO;
import sistemaBancario.dto.LancamentoDTO;
import sistemaBancario.models.Lancamento;
import sistemaBancario.repository.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;

	public void realizarLancamento(Lancamento lancamento) {
		repository.save(lancamento);
	}

	public ArrayList<LancamentoDTO> getLancamentos(Long id, LocalDate dataInicio, LocalDate dataFim) {
		ArrayList<Lancamento> lancamentos = repository.findAllByDataLancamentoBetween(id, dataInicio, dataFim);
		ArrayList<LancamentoDTO> lancamentosDTO = convertLancamentoToLancamentoDTO(lancamentos);

		return lancamentosDTO;
	}
	public ArrayList<LancamentoDTO> getLancamentos(Long contaId) {
		ArrayList<Lancamento> lancamentos = repository.findAllByContaOrigem_id(contaId);
		ArrayList<LancamentoDTO> lancamentosDTO = convertLancamentoToLancamentoDTO(lancamentos);

		return lancamentosDTO;
	}

	private ArrayList<LancamentoDTO> convertLancamentoToLancamentoDTO(ArrayList<Lancamento> lancamentos){
		ArrayList<LancamentoDTO> lancamentosDTO = new ArrayList<>();

		lancamentos.forEach(lancamento -> {
			LancamentoDTO lancamentoDTO = new LancamentoDTO();
			lancamentoDTO.setDate(lancamento.getData().getCreatedAt().toLocalDate());
			lancamentoDTO.setContaOrigem(new ContaSimplesDTO(lancamento.getContaOrigem().getTitular().getLogin(),lancamento.getContaOrigem().getSigla()));
			lancamentoDTO.setContaDestino(new ContaSimplesDTO(lancamento.getContaDestino().getTitular().getLogin(),lancamento.getContaDestino().getSigla()));
			lancamentoDTO.setPlanoConta(lancamento.getPlanoConta().getFinalidade());
			lancamentoDTO.setValor(lancamento.getValor());
			lancamentoDTO.setDescricao(lancamento.getDescricao());
			lancamentosDTO.add(lancamentoDTO);
		});

		return lancamentosDTO;
	}
}
