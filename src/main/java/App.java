import javax.persistence.EntityManager;

import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;
import sistemaBancario.utils.ConexaoFactory;

public class App {
	public static void main(String[] args) {
		// DATABASE CONNECTION CHECK
		// EntityManager em = ConexaoFactory.getConexao();
		
		Usuario user = new Usuario();
		user.setLogin("login");
		user.setCpf("11111111111");
		user.setNome("nome");
		user.setSenha("senha");
		
		UsuarioRepository urep = new UsuarioRepository();
		//CREATE
		urep.create(user);
		System.out.println("CREATED");
		
		//FIND
		Usuario userCheck = urep.findById(user.getId());
		System.out.println("FOUND");
		System.out.println(userCheck.getNome());
		
		//UPDATE
		user.setNome("novo nome");
		userCheck = urep.findById(user.getId());
		System.out.println("UPDATED");
		System.out.println(userCheck.getNome());

		//DELETE
		urep.delete(user);
		System.out.println("DELETED");
		
	}
}
