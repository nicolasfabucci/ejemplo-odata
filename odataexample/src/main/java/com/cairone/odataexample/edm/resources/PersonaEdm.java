package com.cairone.odataexample.edm.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cairone.odataexample.EntityServiceRegistar;
import com.cairone.odataexample.entities.PersonaEntity;
import com.cairone.odataexample.enums.GeneroEnum;
import com.cairone.odataexample.utils.FechaUtil;
import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmNavigationProperty;
import com.sdl.odata.api.edm.annotations.EdmProperty;

@EdmEntity(name = "Persona", key = { "tipoDocumentoId", "numeroDocumento" }, namespace = EntityServiceRegistar.NAME_SPACE, containerName = EntityServiceRegistar.CONTAINER_NAME)
@EdmEntitySet("Personas")
public class PersonaEdm {

	@EdmProperty(nullable = false)
	private Integer tipoDocumentoId = null;
	
	@EdmProperty(nullable = false)
	private String numeroDocumento = null;
	
	@EdmProperty(nullable = false, maxLength=100)
	private String nombres = null;

	@EdmProperty(nullable = false, maxLength=100)
	private String apellidos = null;

	@EdmProperty(maxLength=100)
	private String apodo = null;

	@EdmNavigationProperty
	private LocalidadEdm localidad = null;
	
	@EdmProperty
	private LocalDate fechaAlta = null;
	
	@EdmProperty
	private GeneroEnum genero = null;
	
	@EdmNavigationProperty
	private List<PersonaSectorEdm> sectores = null;
	
	public PersonaEdm() {
		this.sectores = new ArrayList<PersonaSectorEdm>();
	}

	public PersonaEdm(Integer tipoDocumentoId, String numeroDocumento, String nombres, String apellidos, String apodo, LocalidadEdm localidad, LocalDate fechaAlta, GeneroEnum genero) {
		super();
		this.tipoDocumentoId = tipoDocumentoId;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.localidad = localidad;
		this.fechaAlta = fechaAlta;
		this.genero = genero;
		this.sectores = new ArrayList<PersonaSectorEdm>();
	}
	
	public PersonaEdm(PersonaEntity personaEntity) {
		this(personaEntity.getTipoDocumento().getId(), personaEntity.getNumeroDocumento(), personaEntity.getNombres(), personaEntity.getApellidos(), personaEntity.getApodo(), new LocalidadEdm(personaEntity.getLocalidad()), FechaUtil.asLocalDate(personaEntity.getFechaAlta()), personaEntity.getGenero());
	}

	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public LocalidadEdm getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEdm localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public List<PersonaSectorEdm> getSectores() {
		return sectores;
	}

	public void setSectores(List<PersonaSectorEdm> sectores) {
		this.sectores = sectores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
		result = prime * result
				+ ((tipoDocumentoId == null) ? 0 : tipoDocumentoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaEdm other = (PersonaEdm) obj;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		if (tipoDocumentoId == null) {
			if (other.tipoDocumentoId != null)
				return false;
		} else if (!tipoDocumentoId.equals(other.tipoDocumentoId))
			return false;
		return true;
	}
	
}
