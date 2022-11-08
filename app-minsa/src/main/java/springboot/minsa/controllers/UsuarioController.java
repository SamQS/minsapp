package springboot.minsa.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.minsa.models.Rol;
import springboot.minsa.models.Servicio;
import springboot.minsa.models.Establecimiento;
import springboot.minsa.models.Profesion;
import springboot.minsa.models.Referencia;
import springboot.minsa.models.Usuario;
import springboot.minsa.repository.UsuarioRepository;
import springboot.minsa.services.EstablecimientoService;
import springboot.minsa.services.NivelService;
import springboot.minsa.services.ReferenciaService;
import springboot.minsa.services.RolService;
import springboot.minsa.services.ServicioServices;
import springboot.minsa.services.UsuarioService;
import springboot.minsa.services.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioRepository;
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RolService rolService;

	@Autowired
	private NivelService nivelService;

	@Autowired
	private ServicioServices servServices;

	@Autowired
	private EstablecimientoService centroService;

	@Autowired
	private ReferenciaService refService;

	@Autowired
	private ServicioServices servService;

	@Autowired
	private EstablecimientoService estabServ;

	@GetMapping("")
	public String home() { // MENU ADMINISTRADOR

		return "usuario/login";
	}
	@GetMapping("/director") // MENU ADMINISTRATIVO INTERNO
	public String director() {
		return "usuario/director";
	}

	@GetMapping("/menuCitas")
	public String menuCitas() {

		return "usuario/menuCitas";
	}

	// Action : LISTAR

	@GetMapping("/listar")
	public String listar(Map<String, Object> model) {

		List<Usuario> usuarios = usuarioService.findAll();

		model.put("usuarios", usuarios);
		return "usuario/listar";
	}

	// Action : FORMULARIO

	@GetMapping("/form")
	public String crear(Map<String, Object> model) {

		List<Profesion> profesiones = rolService.findAll();
		List<Rol> roles = nivelService.findAll();

		Usuario usuario = new Usuario();

		model.put("profesiones", profesiones);
		model.put("roles", roles);
		model.put("usuario", usuario);

		return "usuario/form";
	}

	// ACTION : GET ONE

	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {

		Optional<Usuario> usuario = usuarioService.findById(id);
		List<Profesion> profesiones = rolService.findAll();
		List<Rol> roles = nivelService.findAll();

		model.put("usuario", usuario);
		model.put("profesiones", profesiones);
		model.put("roles", roles);
		return "usuario/editar";
	}

	// ACTION : SAVE

	@PostMapping("/form")
	public String guardar(Usuario usuario) {

		usuarioService.save(usuario);

		return "redirect:/listar";
	}

	// ACTION : UPDATE
	@PostMapping("/update")
	public String update(Usuario usuario) {

		Optional<Usuario> usuarioOp = usuarioService.findById(usuario.getId());
		/*
		 * if (usuarioOp.isPresent()) {
		 * usuario.setPassword(usuarioOp.get().getPassword()); }
		 */
		usuarioService.save(usuario);

		return "redirect:/listar";
	}

	// ACTION : DELETE
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id) {

		if (id > 0) {
			usuarioService.deleteById(id);
		}

		return "redirect:/listar";
	}

	// USUARIOS DE TIPO ASISTENCIAL
	@GetMapping("/menuInterno") // MENU ADMINISTRATIVO INTERNO
	public String menuAsistencial() {
		return "usuario/menu2";
	}

	@GetMapping("/listarServicios")
	public String listarServicios(Map<String, Object> model) {

		List<Servicio> servicios = servServices.findAll();
		model.put("servicios", servicios);
		return "servicios/listar";
	}

	@GetMapping("/registrarServicio")
	public String crearServicio(Map<String, Object> model) {

		Servicio servicio = new Servicio();
		model.put("servicio", servicio);

		return "servicios/form";
	}

	@PostMapping("/saveServicio")
	public String guardarServicio(Servicio centro) {

		servServices.save(centro);

		return "redirect:/listarServicios";
	}

	// VER DETALLE DEL SERVICIO
	@GetMapping("/verServicio/{id}")
	public String verServicio(@PathVariable Integer id, Model model) {

		Servicio servicio = servServices.getOne(id);

		model.addAttribute("servicio", servicio);

		return "servicios/ver";
	}

	@GetMapping(value = "/registrarServicio/{id}")
	public String editarServicio(@PathVariable(value = "id") Integer id, Map<String, Object> model) {

		Servicio servicio = servServices.getOne(id);

		model.put("servicio", servicio);

		return "servicios/editar";
	}

	@PostMapping("/updateServicio")
	public String updateServicio(Servicio servicio) {

		servServices.save(servicio);

		return "redirect:/listarServicios";
	}

	@GetMapping("/deleteServicio/{id}")
	public String eliminarServicio(@PathVariable(value = "id") Integer id) {

		if (id > 0) {
			servServices.delete(id);
		}

		return "redirect:/listarServicios";
	}

	/*
	 * =============================================================================
	 * ==========================================
	 */

	// METODOS PARA CENTROS DE REFERENCIA

	// LISTAR TODOS LOS CENTROS DISPONIBLES
	@GetMapping("/listarCentros")
	public String listarCentros(Map<String, Object> model) {

		List<Establecimiento> establecimientos = centroService.findAll();
		model.put("establecimientos", establecimientos);
		return "centro/listar";
	}

	// FORMULARIO PARA REGISTRAR UN CENTRO
	@GetMapping("/registrarCentro")
	public String crearCentro(Map<String, Object> model) {

		Establecimiento establecimiento = new Establecimiento();
		model.put("establecimiento", establecimiento);

		return "centro/form";
	}

	// GUARDAR EL CENTRO
	@PostMapping("/saveCentro")
	public String guardarCentro(Establecimiento centro) {

		centroService.save(centro);

		return "redirect:/listarCentros";
	}

	// VER DETALLE DEL CENTRO
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {

		Establecimiento establecimiento = centroService.findOne(id);

		model.addAttribute("establecimiento", establecimiento);

		return "centro/ver";
	}

	@GetMapping(value = "/registrarCentro/{id}")
	public String editarCentro(@PathVariable(value = "id") Integer id, Map<String, Object> model) {

		Establecimiento establecimiento = centroService.findOne(id);

		model.put("establecimiento", establecimiento);

		return "centro/editar";
	}

	// EDITAR CENTRO
	@PostMapping("/updateCentro")
	public String updateCentro(Establecimiento establecimiento) {

		centroService.save(establecimiento);

		return "redirect:/listarCentros";
	}

	// ELIMINAR CENTRO

	@GetMapping("/deleteCentro/{id}")
	public String eliminarCentro(@PathVariable(value = "id") Integer id) {

		if (id > 0) {
			centroService.deleteById(id);
		}

		return "redirect:/listarCentros";
	}

	// login
	@PostMapping("/acceder")
	public String acceder(Usuario usuario, HttpSession session) {

		Optional<Usuario> user = usuarioService.findByDniAndPass(usuario.getDni(), usuario.getPassword());

		if (user.isPresent()) {

			session.setAttribute("idusuario", user.get().getId());

			if (user.get().getRol().getNivel().equals("AdministrativoExterno")) {
				return "redirect:/menuCitas";
			} 
			else if (user.get().getRol().getNivel().equals("Administrativo")) {
				return "redirect:/menuInterno";
			}
			else if (user.get().getRol().getNivel().equals("Director")) {
				return "redirect:/director";
			}
			else if (user.get().getRol().getNivel().equals("Asistencial")) {
				return "redirect:/administrador";
			} 
			
		}

		return "redirect:/login";
	}

	// Cerrar sesion
	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("idusuario");
		return "redirect:/login";
	}

	/* REFERENCIAS ESTADOS */

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

	// MODIFICAR STATUS DE REFERENCIAS

	// CAMBIA STATUS ENVIADA
	@GetMapping("/actualizarStatus/{id}")
	public String modificarStatusEnviado(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarEnviado(referencia.getId());

		return "redirect:/listarRefPendientes";
	}

	// CAMBIA A ANULADA
	@GetMapping("/actualizarAnuladas/{id}")
	public String modificarAnulada(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarAnulado(referencia.getId());

		return "redirect:/refEnviadas";
	}

	// CAMBIA A OBSERVADA
	@GetMapping("/actualizarObservadas/{id}")
	public String modificarObs(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarObservado(referencia.getId());

		return "redirect:/listarRefPendientes";
	}

	// CAMBIO A PENDIENTE
	@GetMapping("/actualizarPendiente/{id}")
	public String modificarPendiente(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarPendiente(referencia.getId());

		return "redirect:/refObservadas";
	}

	// CAMBIO A CITADA
	@GetMapping("/actualizarCitada/{id}")
	public String modificarCitada(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarEnviado(referencia.getId());

		return "redirect:/listarRefPendientes";
	}
	
	// CAMBIO A PENDIENTE
	@GetMapping("/actualizarDeAlta/{id}")
	public String modificarDeAlta(@PathVariable Integer id) {

		Referencia referencia = refService.findById(id);

		refService.actualizarAlta(referencia.getId());

		return "redirect:/citasEnviadas";
	}

	// EDITAR REFERENCIAS
	@GetMapping("/verReferencia/{id}")
	public String verReferencia(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "referencia/verReferenciaPendiente";
	}

	@GetMapping("/verReferenciaEnviada/{id}")
	public String verReferenciaEnviada(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "referencia/verReferenciaEnviada";
	}

	@GetMapping("/verReferenciaObservada/{id}")
	public String verReferenciaObservad(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "referencia/verReferenciaObservada";
	}

	@GetMapping("/verReferenciaObservadaa/{id}")
	public String verReferenciaObservada(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "referencia/verReferenciaObservadaa";
	}
	
	
	@GetMapping("/habilitarCamposRefObserv/{id}")
	public String verReferenciaObservadHabilitada(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "referencia/verRefCamposHabilitados";
	}
	
	@PostMapping("/updateRefObsv")
	public String actualizarRefObservada(Referencia referencia) {
		
		referencia.setStatus("OBSERVADA");
		refService.save(referencia);
		return "redirect:/refObservadas";
	}
	
	


	// EDITAR REFERENCIA DE PENDIENTE A OBSERVADA
	@PostMapping("/updateReferenciaAObservada")
	public String updateReferenciaObservada(Referencia referencia) {

		Referencia ref = refService.findById(referencia.getId());

		Servicio servicio = servServices.getOne(ref.getEspecialidadDestino().getId());

		referencia.setStatus("OBSERVADA");
		referencia.setFecha(ref.getFecha());
		referencia.setHora(ref.getHora());
		referencia.setOrigen(ref.getOrigen());
		referencia.setEstablecimientodestino(ref.getEstablecimientodestino());
		referencia.setEspecialidadDestino(servicio);
		referencia.setDniPaciente(ref.getDniPaciente());
		referencia.setNomPaciente(ref.getNomPaciente());
		referencia.setApePatPaciente(ref.getApePatPaciente());
		referencia.setApeMatPaciente(ref.getApeMatPaciente());
		referencia.setGenero(ref.getGenero());
		referencia.setEdad(ref.getEdad());
		referencia.setDirecPaciente(ref.getDirecPaciente());
		referencia.setDistriPaciente(ref.getDistriPaciente());
		referencia.setDptoPaciente(ref.getDptoPaciente());
		referencia.setResumen1(ref.getResumen1());
		referencia.setResumen2(ref.getResumen2());
		referencia.setResumen3(ref.getResumen3());
		referencia.setResumen4(ref.getResumen4());
		referencia.setResumen5(ref.getResumen5());
		referencia.setResumen6(referencia.getResumen6());
		referencia.setCoordReferencia(ref.getCoordReferencia());
		referencia.setServicios(ref.getServicios());
		referencia.setCondicionPaciente(ref.getCondicionPaciente());
		refService.save(referencia);

		return "redirect:/listarRefPendientes";
	}
	
	@GetMapping("/citasPendientes")
	public String citasPendientes(Map<String, Object> model) {

		List<Referencia> refEnviadas = refService.findEnviadas();

		model.put("refEnviadas", refEnviadas);

		return "citas/enviadas";
	}

	@PostMapping("/updateReferenciaACitada")
	public String updateReferenciaACitada(Referencia referencia) {

		Referencia ref = refService.findById(referencia.getId());

		Servicio servicio = servServices.getOne(ref.getEspecialidadDestino().getId());

		referencia.setStatus("CITADA");
		referencia.setFecha(ref.getFecha());
		referencia.setHora(ref.getHora());
		referencia.setOrigen(ref.getOrigen());
		referencia.setEstablecimientodestino(ref.getEstablecimientodestino());
		referencia.setEspecialidadDestino(servicio);
		referencia.setDniPaciente(ref.getDniPaciente());
		referencia.setNomPaciente(ref.getNomPaciente());
		referencia.setApePatPaciente(ref.getApePatPaciente());
		referencia.setApeMatPaciente(ref.getApeMatPaciente());
		referencia.setGenero(ref.getGenero());
		referencia.setEdad(ref.getEdad());
		referencia.setDirecPaciente(ref.getDirecPaciente());
		referencia.setDistriPaciente(ref.getDistriPaciente());
		referencia.setDptoPaciente(ref.getDptoPaciente());
		referencia.setResumen1(ref.getResumen1());
		referencia.setResumen2(ref.getResumen2());
		referencia.setResumen3(ref.getResumen3());
		referencia.setResumen4(ref.getResumen4());
		referencia.setResumen5(ref.getResumen5());
		referencia.setResumen6(referencia.getResumen6());
		referencia.setCoordReferencia(ref.getCoordReferencia());
		referencia.setServicios(ref.getServicios());
		referencia.setCondicionPaciente(ref.getCondicionPaciente());
		refService.save(referencia);

		return "redirect:/citasPendientes";
	}
	
	@GetMapping("/citasEnviadas")
	public String citasEnviadas(Map<String, Object> model) {

		List<Referencia> refCitadas = refService.findCitadas();

		model.put("refCitadas", refCitadas);

		return "citas/citadas";
	}


	@GetMapping("/verReferenciaEnviadaCita/{id}")
	public String verReferenciaEnviadaCita(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "citas/verRefCitaEnviada";
	}

	@GetMapping("/verRefParaCitar/{id}")
	public String verReferenciaEnviadaCitaUpdateCitar(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "citas/verRefCitaEnviadaCitar";
	}

	@GetMapping("/detalleRefCitada/{id}")
	public String detalleRefCitada(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "citas/detalleRefCitada";
	}
	@GetMapping("/detalleRefCitadaa/{id}")
	public String detalleRefCitadaa(@PathVariable Integer id, Map<String, Object> model) {

		List<Servicio> servicios = servService.findAll();
		List<Establecimiento> establecimientos = estabServ.findAll();
		Referencia referencia = refService.findById(id);
		model.put("servicios", servicios);
		model.put("establecimientos", establecimientos);
		model.put("referencia", referencia);

		return "citas/detalleRefCitadaa";
	}

}
