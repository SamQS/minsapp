package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Departamento;
import springboot.minsa.repository.DepaRepository;

@Service
public class DepaServiceImpl implements DepaService{

	@Autowired
	private DepaRepository dptoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Departamento> listAll() {
	
		return dptoRepository.findAll();
	}

}
