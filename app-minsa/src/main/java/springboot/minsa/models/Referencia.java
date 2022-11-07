package springboot.minsa.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "referencias")
public class Referencia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fech_referencia")
	private Date fecha;

	private String hora;

	private String origen;

	@ManyToOne
	private Establecimiento Establecimientodestino;

	private String dniPaciente;

	private String nomPaciente;

	private String apePatPaciente;

	private String apeMatPaciente;

	private String genero;

	private String edad;

	private String direcPaciente;

	private String distriPaciente;

	private String dptoPaciente;

	private String resumen1;

	private String resumen2;

	private String resumen3;

	private String resumen4;

	private String resumen5;

	private String coordReferencia;

	private String servicios;

	private String status;

	@ManyToOne
	private Servicio especialidadDestino;

	private String condicionPaciente;

	private String resumen6;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_cita")
	private Date fechaCita;

	private String horaCita;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Establecimiento getEstablecimientodestino() {
		return Establecimientodestino;
	}

	public void setEstablecimientodestino(Establecimiento establecimientodestino) {
		Establecimientodestino = establecimientodestino;
	}

	public String getNomPaciente() {
		return nomPaciente;
	}

	public void setNomPaciente(String nomPaciente) {
		this.nomPaciente = nomPaciente;
	}

	public String getApePatPaciente() {
		return apePatPaciente;
	}

	public void setApePatPaciente(String apePatPaciente) {
		this.apePatPaciente = apePatPaciente;
	}

	public String getApeMatPaciente() {
		return apeMatPaciente;
	}

	public void setApeMatPaciente(String apeMatPaciente) {
		this.apeMatPaciente = apeMatPaciente;
	}

	public String getDirecPaciente() {
		return direcPaciente;
	}

	public void setDirecPaciente(String direcPaciente) {
		this.direcPaciente = direcPaciente;
	}

	public String getDistriPaciente() {
		return distriPaciente;
	}

	public void setDistriPaciente(String distriPaciente) {
		this.distriPaciente = distriPaciente;
	}

	public String getDptoPaciente() {
		return dptoPaciente;
	}

	public void setDptoPaciente(String dptoPaciente) {
		this.dptoPaciente = dptoPaciente;
	}

	public String getResumen1() {
		return resumen1;
	}

	public void setResumen1(String resumen1) {
		this.resumen1 = resumen1;
	}

	public String getResumen2() {
		return resumen2;
	}

	public void setResumen2(String resumen2) {
		this.resumen2 = resumen2;
	}

	public String getResumen3() {
		return resumen3;
	}

	public void setResumen3(String resumen3) {
		this.resumen3 = resumen3;
	}

	public String getResumen4() {
		return resumen4;
	}

	public void setResumen4(String resumen4) {
		this.resumen4 = resumen4;
	}

	public String getResumen5() {
		return resumen5;
	}

	public void setResumen5(String resumen5) {
		this.resumen5 = resumen5;
	}

	public String getCoordReferencia() {
		return coordReferencia;
	}

	public void setCoordReferencia(String coordReferencia) {
		this.coordReferencia = coordReferencia;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public String getCondicionPaciente() {
		return condicionPaciente;
	}

	public void setCondicionPaciente(String condicionPaciente) {
		this.condicionPaciente = condicionPaciente;
	}

	public String getResumen6() {
		return resumen6;
	}

	public void setResumen6(String resumen6) {
		this.resumen6 = resumen6;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	public Servicio getEspecialidadDestino() {
		return especialidadDestino;
	}

	public void setEspecialidadDestino(Servicio especialidadDestino) {
		this.especialidadDestino = especialidadDestino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	private static final long serialVersionUID = 1L;

}
