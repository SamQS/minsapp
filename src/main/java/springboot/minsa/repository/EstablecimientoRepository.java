package springboot.minsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.minsa.models.Establecimiento;

public interface EstablecimientoRepository  extends JpaRepository<Establecimiento, Integer>{

	@Query("SELECT e FROM Establecimiento e WHERE e.estado = 'DISPONIBLE'")
	List<Establecimiento> centroReferenciaDispoonibles();
}
