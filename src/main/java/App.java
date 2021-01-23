import javax.persistence.EntityManager;

import sistemaBancario.utils.ConexaoFactory;

public class App {
	public static void main(String[] args) {
		EntityManager em = ConexaoFactory.getConexao();
	}
}
