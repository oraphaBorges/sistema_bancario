package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sistemaBancario.dto.UsuarioDTO;
import sistemaBancario.enums.Sigla;
import sistemaBancario.models.Conta;
import sistemaBancario.models.PlanoConta;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public void cadastrar(UsuarioDTO usuarioDTO) throws Exception {
		Usuario usuario = converterDTO(usuarioDTO);

		if (repository.existsByLogin(usuario.getLogin()))
			throw new IllegalStateException();
		
		String passCrip = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(passCrip);
		
		usuario.addConta(new Conta("POUPANÇA", Sigla.POUPANCA, usuario));
		usuario.addConta(new Conta("CREDITO", Sigla.CREDITO, usuario));
		usuario.addConta(new Conta("CORRENTE", Sigla.CORRENTE, usuario));
		
		usuario.addPlanoConta(new PlanoConta("PAGAMENTO"));
		usuario.addPlanoConta(new PlanoConta("DEPOSITO"));
		usuario.addPlanoConta(new PlanoConta("TRANSFERENCIA"));
		
		repository.save(usuario);
	}
	
	public UsuarioDTO buscar(String login) {
		Usuario usuario = repository.findByLogin(login);
		UsuarioDTO usuarioDTO = convertEntity(usuario);
				
		return usuarioDTO; 
	}
	
	private Usuario converterDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		
		return usuario;
	}
	
	private UsuarioDTO convertEntity(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setLogin(usuario.getLogin());
		usuarioDTO.setCpf(usuario.getCpf());
		usuarioDTO.setNome(usuario.getNome());
		
		return usuarioDTO ;
	}

}
