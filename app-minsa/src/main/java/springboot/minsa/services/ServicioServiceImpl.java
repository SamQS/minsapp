package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Servicio;
import springboot.minsa.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioServices{

	@Autowired
	private ServicioRepository servRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		
		return servRepo.findAll();
	}

	@Override
	public Servicio getOne(Integer id) {
		
		return servRepo.findById(id).orElse(null);
	}

	@Override
	public Servicio save(Servicio servicio) {
		// TODO Auto-generated method stub
		return servRepo.save(servicio);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		servRepo.deleteById(id);
	}

}
