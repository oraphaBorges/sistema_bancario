package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioDTOparaUsuario(usuarioDTO);
		String passCrip = passwordEncoder.encode(usuario.getSenha());
		// TODO: CHECK IF EXIST
		if (repository.existsByLogin(usuario.getLogin()))
			throw new IllegalStateException("JÃ¡ existe um usuario com o login " + usuario.getLogin());
		usuario.setSenha(passCrip);
		usuario.addConta(new Conta("POUPANÇA", Sigla.POUPANCA, usuario));
		usuario.addConta(new Conta("CREDITO", Sigla.CREDITO, usuario));
		usuario.addConta(new Conta("CORRENTE", Sigla.CORRENTE, usuario));
		
		usuario.addPlanoConta(new PlanoConta("PAGAMENTO"));
		usuario.addPlanoConta(new PlanoConta("DEPOSITO"));
		usuario.addPlanoConta(new PlanoConta("TRANSFERENCIA"));

		return usuarioParaUsuarioDTO(repository.save(usuario));
	}
	git
	public UsuarioDTO buscar(String login) {
		Usuario ul = repository.findByLogin(login);
		UsuarioDTO usuarioDTO = usuarioParaUsuarioDTO(ul);
				
		return usuarioDTO; 
	}
	
	private Usuario usuarioDTOparaUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		
		return usuario;
	}
	
	private UsuarioDTO usuarioParaUsuarioDTO(Usuario usuario) {
		UsuarioDTO ud = new UsuarioDTO();
		ud.setLogin(usuario.getLogin());
		ud.setCpf(usuario.getCpf());
		ud.setNome(usuario.getNome());
		
		return ud ;
	}

}
