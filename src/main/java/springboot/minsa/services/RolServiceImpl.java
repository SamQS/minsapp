package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Profesion;
import springboot.minsa.repository.ProfesionRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private ProfesionRepository rolRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Profesion> findAll() {
		
		return rolRepository.findAll();
	}

}
