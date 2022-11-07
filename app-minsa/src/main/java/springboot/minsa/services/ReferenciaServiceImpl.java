package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.Referencia;
import springboot.minsa.repository.ReferenciaRepository;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

	@Autowired
	private ReferenciaRepository refeRepository;

	@Override
	public List<Referencia> findAll() {

		return refeRepository.findAll();
	}

	@Override
	public Referencia save(Referencia referencia) {

		return refeRepository.save(referencia);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Referencia> findPendientes() {

		return refeRepository.referenciasPendientes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Referencia> findCitadas() {
		// TODO Auto-generated method stub
		return refeRepository.referenciasCitadas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Referencia> findObservadas() {
		// TODO Auto-generated method stub
		return refeRepository.referenciasObservadas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Referencia> findEnviadas() {
		// TODO Auto-generated method stub
		return refeRepository.referenciasEnviadas();
	}

	@Override
	@Transactional
	public void actualizarEstado(Integer id) {
		
		refeRepository.actualizarEstadoACitada(id);
		
	}

	@Override
	@Transactional
	public Referencia findById(Integer id) {
		// TODO Auto-generated method stub
		return refeRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void actualizarEnviado(Integer id) {
		
		refeRepository.actualizarEstadoAEnviada(id);
		
	}

	@Override
	@Transactional
	public void actualizarObservado(Integer id) {
		// TODO Auto-generated method stub
		refeRepository.actualizarEstadoObservado(id);
	}

	@Override
	@Transactional
	public void actualizarAnulado(Integer id) {
		// TODO Auto-generated method stub
		refeRepository.actualizarEstadoAnulada(id);
	}

	@Override
	@Transactional
	public void actualizarPendiente(Integer id) {
		// TODO Auto-generated method stub
		refeRepository.actualizarEstadoPendiente(id);
	}

	@Override
	@Transactional
	public void actualizarAlta(Integer id) {
		// TODO Auto-generated method stub
		refeRepository.actualizarEstadoDeAlta(id);
	}
}
