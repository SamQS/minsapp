package springboot.minsa.services;

import java.util.List;
import java.util.Map;

import springboot.minsa.models.Referencia;

public interface ReferenciaService {

	List<Referencia> findAll();
	
	Referencia save(Referencia referencia);

	List<Referencia> findPendientes();
	
	List<Referencia> findCitadas();
	
	List<Referencia> findObservadas();
	
	List<Referencia> findEnviadas();


	List<Object> findRPendientes();

	List<Object> findRObservadas();

	List<Object> findREnviadas();

	List<Object> findRCitada();

	List<Object> findRAlta();

	List<Object> findRAnulada();

	List<Object> findRCont();








	
	public void actualizarEstado(Integer id ); // a enviado
	
	Referencia findById(Integer id);
	
	
	public void actualizarEnviado(Integer id ); //a enviado
	
	public void actualizarObservado(Integer id );	//a observado
	
	public void actualizarAnulado(Integer id );	//a anulado
	
	public void actualizarPendiente(Integer id );	//a pendiente
	
	public void actualizarAlta(Integer id );	//a de alta
	
}
