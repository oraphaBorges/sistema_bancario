package sistemaBancario.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void cadastrar(UsuarioDTO usuarioDTO) {
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
		repository.save(usuario);
	}
	
	public UsuarioDTO buscar(String login) {
		Usuario ul = repository.findByLogin(login);
		UsuarioDTO ud = new UsuarioDTO();
		ud.setLogin(ul.getLogin());
		ud.setCpf(ul.getCpf());
		ud.setNome(ul.getNome());
		
		return ud; 
	}
	
	private Usuario usuarioDTOparaUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setCpf(usuarioDTO.getCpf());
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		
		return usuario;
	}

}
