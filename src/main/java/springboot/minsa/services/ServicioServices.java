package springboot.minsa.services;

import java.util.List;

import springboot.minsa.models.Servicio;

public interface ServicioServices {

	List<Servicio> findAll();
	
	Servicio save(Servicio servicio);
	
	public Servicio getOne(Integer id);
	
	public void delete(Integer id);
}
