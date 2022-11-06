package springboot.minsa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Establecimiento;
import springboot.minsa.repository.EstablecimientoRepository;

@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{

	@Autowired
	private EstablecimientoRepository establecimientoRepo;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Establecimiento> findAll() {
		// TODO Auto-generated method stub
		return establecimientoRepo.findAll();
	}

	@Override
	@Transactional
	public Establecimiento save(Establecimiento establecimiento) {
		// TODO Auto-generated method stub
		return establecimientoRepo.save(establecimiento);
	}



	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		establecimientoRepo.deleteById(id);
	}

	@Override
	public Establecimiento findOne(Integer id) {
		
		return establecimientoRepo.findById(id).orElse(null);
	}

	@Override
	public List<Establecimiento> establecimientosDisponibles() {
	
		return establecimientoRepo.centroReferenciaDispoonibles();
	}

}
