package springboot.minsa.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.minsa.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByDni(String dni);

	


}
