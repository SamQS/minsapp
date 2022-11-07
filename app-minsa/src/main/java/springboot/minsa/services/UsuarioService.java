package springboot.minsa.services;

import java.util.List;
import java.util.Optional;

import springboot.minsa.models.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Optional<Usuario> findById(Integer id);
	
	public void deleteById(Integer id);
	
	//Optional<Usuario> findByDni(String dni);

	Optional<Usuario> findByDniAndPass(String dni, String password);
}
