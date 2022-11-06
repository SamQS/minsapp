package springboot.minsa.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Profesion;
import springboot.minsa.models.Usuario;
import springboot.minsa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Integer id) {
		
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		usuarioRepository.deleteById(id);
	}



	@Override
	public Optional<Usuario> findByDni(String dni) {
		
		return usuarioRepository.findByDni(dni); 
	}


}
