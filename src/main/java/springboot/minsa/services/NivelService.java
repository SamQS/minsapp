package springboot.minsa.services;

import java.util.List;

import springboot.minsa.models.Rol;

public interface NivelService {

	List<Rol> findAll();
	
	Rol save(Rol nivel);
}
