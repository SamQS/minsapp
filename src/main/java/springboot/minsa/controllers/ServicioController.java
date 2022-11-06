package springboot.minsa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.minsa.models.Departamento;
import springboot.minsa.models.Servicio;
import springboot.minsa.models.ServiciosDisp;
import springboot.minsa.services.DepaService;
import springboot.minsa.services.ServRegionService;
import springboot.minsa.services.ServicioServices;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private DepaService dptoService;
	
	@Autowired
	private ServicioServices servService;
	
	@Autowired
	private ServRegionService serRegionService;
	
	@GetMapping("/servDispRegion")
	public String listServPorRegion(Model model) {
	
		List<Departamento> dptos = dptoService.listAll();
		List<Servicio> servicios = servService.findAll();
		List<ServiciosDisp> ServiciosDiposnibles = serRegionService.findAll();
		
		
		model.addAttribute("ServiciosDiposnibles", ServiciosDiposnibles);
		model.addAttribute("dptos", dptos);
		model.addAttribute("servicios", servicios);
		return "servicios/ServiciosRegion";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Integer id, Model model) {
		
		Servicio servicio = servService.getOne(id);
		
		model.addAttribute("servicio", servicio);
		return "servicios/detalle";
	}
	
}
