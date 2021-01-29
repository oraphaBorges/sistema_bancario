package sistemaBancario.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import sistemaBancario.models.Usuario;
import sistemaBancario.services.UsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioServiceTest {

	private static UsuarioService usuarioService = new UsuarioService();
	
	@Test
	@Order(1)
	public void cadastroTest() {
		Usuario usuario = new Usuario("João da Silva", "joao.silva", "123456", "11111111111");
		usuarioService.cadastrar(usuario);

		Usuario cliente = usuarioService.buscarUsuario(usuario.getLogin());
		assertEquals(usuario, cliente);
	}
	
	@Test
	@Order(2)
	public void cadastroDuplicadoTest() {		
		Usuario usuario = new Usuario("João da Silva", "joao.silva", "123456", "11111111111");
		assertThrows(IllegalStateException.class, () -> usuarioService.cadastrar(usuario));
	
	}
	
	@Test
	@Order(3)
	public void alterarCadastroTest() {
		Usuario usuario = usuarioService.buscarUsuario("joao.silva");
		String novoNome = "João Pires da Silva";
		
		assertNotEquals(usuario.getNome(), novoNome);
		usuario.setNome(novoNome);
		usuarioService.alterarCadastro(usuario);
		
		assertEquals(usuario.getNome(), novoNome);
	}
	
	@Test
	@Order(4)
	public void excluirCadastroTeste() {
		Usuario usuario = usuarioService.buscarUsuario("joao.silva");
		assertNotNull(usuario);
		usuarioService.excluirCadastro(usuario);
		assertThrows(NoResultException.class, () -> usuarioService.buscarUsuario("joao.silva"));
	}
}
