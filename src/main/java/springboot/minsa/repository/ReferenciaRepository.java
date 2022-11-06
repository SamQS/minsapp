package springboot.minsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import springboot.minsa.models.Referencia;

public interface ReferenciaRepository extends JpaRepository<Referencia, Integer>{

	//Listar por estados
	
	@Query("SELECT r FROM Referencia r WHERE r.status = 'PENDIENTE'")
	List<Referencia> referenciasPendientes();
	
	@Query("SELECT r FROM Referencia r WHERE r.status = 'ENVIADA'")
	List<Referencia> referenciasEnviadas();
	
	@Query("SELECT r FROM Referencia r WHERE r.status = 'OBSERVADA'")
	List<Referencia> referenciasObservadas();
	
	@Query("SELECT r FROM Referencia r WHERE r.status = 'CITADA'")
	List<Referencia> referenciasCitadas();
	
	
	
	//Actualizar los estados	
	@Query("UPDATE Referencia r SET r.status = 'OBSERVADA' where r.id = ?1")
	@Modifying
	public void actualizarEstadoObservado(Integer id);  //A OBERVADA
	
	
	@Query("UPDATE Referencia r SET r.status = 'ENVIADA' where r.id = ?1")
	@Modifying
	public void actualizarEstadoAEnviada(Integer id);
	
	@Query("UPDATE Referencia r SET r.status = 'CITADA' where r.id = ?1")
	@Modifying
	public void actualizarEstadoACitada(Integer id);
	
	
	@Query("UPDATE Referencia r SET r.status = 'ANULADA' where r.id = ?1")
	@Modifying
	public void actualizarEstadoAnulada(Integer id);
	
	
	@Query("UPDATE Referencia r SET r.status = 'PENDIENTE' where r.id = ?1")
	@Modifying
	public void actualizarEstadoPendiente(Integer id);
	
}
