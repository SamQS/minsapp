package springboot.minsa.services;

import java.util.List;
import java.util.Optional;

import springboot.minsa.models.Establecimiento;

public interface EstablecimientoService {

	List<Establecimiento> findAll();

	Establecimiento save(Establecimiento establecimiento);

	Establecimiento findOne(Integer id);

	public void deleteById(Integer id);
	
	List<Establecimiento> establecimientosDisponibles();
}
