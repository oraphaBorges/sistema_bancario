package sistemaBancario.Services;


import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;

public class UsuarioService {

	private UsuarioRepository repository = new UsuarioRepository();

				
		public void incluir(Usuario usuario) {
			
			if(repository.exists(usuario.getLogin())) {
				throw new IllegalStateException("JÃ¡ existe um usuario com o login " + usuario.getLogin());
				
		}else {
			repository.create(usuario);
		}	
			System.out.println("FIM");
		}
			
		

}

