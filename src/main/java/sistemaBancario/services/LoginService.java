package sistemaBancario.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sistemaBancario.dto.LoginDTO;
import sistemaBancario.dto.SessaoDTO;
import sistemaBancario.models.Usuario;
import sistemaBancario.repository.UsuarioRepository;
import sistemaBancario.security.JWTConstants;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	public SessaoDTO logar(LoginDTO loginDTO) throws Exception {
		System.out.println("Login");
		if (loginDTO == null || loginDTO.usuario.isEmpty() || loginDTO.senha.isEmpty()) {
			throw new RuntimeException("Login e senha são requeridos");
		}

		Usuario usuario = repository.findByLogin(loginDTO.usuario);
		
		boolean senhaOk = encoder.matches(loginDTO.senha,usuario.getSenha());

		if (!senhaOk) {
			throw new RuntimeException("Senha inválida para o login: " + loginDTO.usuario);
		}

		// tempo do token = 1 horas
		long tempoToken = 1 * 60 * 60 * 1000;
		SessaoDTO sessaoDTO = new SessaoDTO();
		sessaoDTO.setDataInicio(new Date(System.currentTimeMillis()));
		sessaoDTO.setDataFim(new Date(System.currentTimeMillis() + tempoToken));

		sessaoDTO.setLogin(usuario.getLogin());

		sessaoDTO.setToken(JWTConstants.PREFIX + getJWTToken(sessaoDTO));

		return sessaoDTO;
	}
	//como vc gerenciaria a nivel de banco o role de um usuario
	private String getJWTToken(SessaoDTO sessaoDTO) {
		String role = "ROLE_USER";
		if(sessaoDTO.getLogin().equals("admin"))
			role = "ROLE_ADMIN";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);

		String token = Jwts.builder().setSubject(sessaoDTO.getLogin())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(sessaoDTO.getDataInicio()).setExpiration(sessaoDTO.getDataFim())
				.signWith(SignatureAlgorithm.HS512, JWTConstants.KEY.getBytes()).compact();

		return token;
	}
}
