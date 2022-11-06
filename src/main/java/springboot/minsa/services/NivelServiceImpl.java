package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Rol;
import springboot.minsa.repository.RolRepository;

@Service
public class NivelServiceImpl implements NivelService {

	@Autowired
	private RolRepository nivelRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {

		return nivelRepository.findAll();
	}

	@Override
	@Transactional
	public Rol save(Rol nivel) {

		return nivelRepository.save(nivel);
	}

}
