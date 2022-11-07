package springboot.minsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.minsa.models.ServiciosDisp;

public interface DetalleServicioRepository extends JpaRepository<ServiciosDisp, Integer>{

}
