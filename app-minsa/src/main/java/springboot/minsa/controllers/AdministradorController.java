package springboot.minsa.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.minsa.models.Departamento;
import springboot.minsa.models.Establecimiento;
import springboot.minsa.models.Referencia;
import springboot.minsa.models.Servicio;
import springboot.minsa.models.ServiciosDisp;
import springboot.minsa.services.DepaService;
import springboot.minsa.services.EstablecimientoService;
import springboot.minsa.services.ReferenciaService;
import springboot.minsa.services.ServRegionService;
import springboot.minsa.services.ServicioServices;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ServicioServices servService;

	@Autowired
	private ReferenciaService refService;

	@Autowired
	private EstablecimientoService estabServ;

	// Vista para gestion de referencias
	@GetMapping("")
	public String home() {

		return "administrador/home";	//MENU ASISTENCIAL
	}

	@GetMapping("/form")
	public String formRef(Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();

		Referencia referencia = new Referencia();
		referencia.setOrigen("CS PACHACAMAC");
		referencia.setStatus("PENDIENTE");
		model.put("referencia", referencia);

		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		return "referencia/form";
	}

	@PostMapping("/saveRefe")
	public String guardarReferencia(Referencia referencia) {

		referencia.setOrigen("CS PACHACAMAC");
		referencia.setStatus("PENDIENTE");
		refService.save(referencia);

		return "redirect:/administrador";
	}

	@Autowired
	private DepaService dptoService;

	@Autowired
	private ServicioServices servServices;

	@Autowired
	private ServRegionService serRegionService;

	@GetMapping("/servDispRegion")
	public String listServPorRegion(Model model) {

		List<Establecimiento> estabDisponibles = estabServ.establecimientosDisponibles();

		model.addAttribute("estabDisponibles", estabDisponibles);

		return "servicios/ServiciosRegion";
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Integer id, Model model) {

		Establecimiento establecimiento = estabServ.findOne(id);
		
		model.addAttribute("establecimiento", establecimiento);
		return "servicios/detalle";
	}

	@GetMapping("/listarReferencia")
	public String listReferencia(Model model) {

		List<Referencia> referencias = refService.findAll();

		model.addAttribute("referencias", referencias);
		return "referencia/listarReferencia";
	}









	// ************* ESTADOS DE LAS REFERENCIAS ****************//

	// REFERENCIAS PENDIENTES
	@GetMapping("/listarRefPendientes")
	public String listaRefPend(Map<String, Object> model) {

		List<Referencia> pendientes = refService.findPendientes();

		model.put("pendientes", pendientes);

		return "referencia/pendientes";
	}

	// REFERENCIAS ENVIADAS
	@GetMapping("/refEnviadas")
	public String refEnviadas(Map<String, Object> model) {

		List<Referencia> refEnviadas = refService.findEnviadas();

		model.put("refEnviadas", refEnviadas);

		return "referencia/enviadas";
	}

	// REFERENCIAS OBSERVADAS
	@GetMapping("/refObservadas")
	public String refObservadas(Map<String, Object> model) {

		List<Referencia> refObservadas = refService.findObservadas();

		model.put("refObservadas", refObservadas);

		return "referencia/observadas";
	}

	// REFERENCIAS CITADAS
	@GetMapping("/refCitadas")
	public String refCitadas(Map<String, Object> model) {

		List<Referencia> refCitadas = refService.findCitadas();

		model.put("refCitadas", refCitadas);

		return "referencia/citadas";
	}

	// CARTERA DE SERVICIOS

	@GetMapping("/listarServicios")
	public String listarServicios(Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();

		model.put("servicios", servicios);

		return "administrador/listarServicios";
	}

	





}
