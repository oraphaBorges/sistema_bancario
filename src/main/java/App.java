import javax.persistence.EntityManager;

import sistemaBancario.models.Conta;
import sistemaBancario.models.Sigla;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.ContaRepository;
import sistemaBancario.repository.UsuarioRepository;
import sistemaBancario.utils.ConexaoFactory;

public class App {
	public static void main(String[] args) {
		// DATABASE CONNECTION CHECK
		//EntityManager em = ConexaoFactory.getConexao();
		
		// USUARIO CRUD
		Usuario user = new Usuario();
		user.setLogin("login");
		user.setCpf("11111111111");
		user.setNome("Rafael Marangoni");
		user.setSenha("1234");
		
		UsuarioRepository urep = new UsuarioRepository();
		//CREATE
		urep.create(user);
		System.out.println("CREATED");
		
		//FIND
//		Usuario userCheck = urep.findById(user.getId());
//		System.out.println("FOUND");
//		System.out.println(userCheck.getNome());
		
		//UPDATE
//		user.setNome("novo nome");
//		urep.update(user);
//		userCheck = urep.findById(user.getId());
//		System.out.println("UPDATED");
//		System.out.println(userCheck.getNome());

		//DELETE
//		urep.delete(user);
//		System.out.println("DELETED");
		
		
		// CONTA CRUD
		Conta conta = new Conta();
		conta.setNome("teste");
		conta.setSaldo(1253.66);
		conta.setSigla(Sigla.CORRENTE);
		
		ContaRepository crep = new ContaRepository();
		//CREATE
		crep.create(conta);
		System.out.println("CREATED");
		
		//FIND
//		Conta contaCheck = crep.findById(conta.getId());
//		System.out.println("FOUND");
//		System.out.println(contaCheck.getSaldo());
		
		//UPDATE
//		conta.setSaldo(2687.99);
//		crep.update(conta);
//		contaCheck = crep.findById(conta.getId());
//		System.out.println("UPDATED");
//		System.out.println(contaCheck.getSaldo());

		//DELETE
//		crep.delete(conta);
//		System.out.println("DELETED");
		
	}
}
