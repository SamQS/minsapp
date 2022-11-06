package springboot.minsa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.minsa.models.ServiciosDisp;
import springboot.minsa.repository.DetalleServicioRepository;

@Service
public class ServRegionServiceImpl implements ServRegionService{

	@Autowired
	private DetalleServicioRepository detailRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<ServiciosDisp> findAll() {
		
		return detailRepository.findAll();
	}

}
