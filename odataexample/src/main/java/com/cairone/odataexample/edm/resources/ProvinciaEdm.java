package com.cairone.odataexample.edm.resources;

import com.cairone.odataexample.EntityServiceRegistar;
import com.cairone.odataexample.entities.ProvinciaEntity;
import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmNavigationProperty;
import com.sdl.odata.api.edm.annotations.EdmProperty;

@EdmEntity(name = "Provincia", key = { "PaisId", "Id" }, namespace = EntityServiceRegistar.NAME_SPACE, containerName = EntityServiceRegistar.CONTAINER_NAME)
@EdmEntitySet("Provincias")
public class ProvinciaEdm {

	@EdmProperty(name = "Id", nullable = false)
	private Integer id = null;

	@EdmProperty(name = "PaisId", nullable = false)
	private Integer paisId = null;

	@EdmNavigationProperty(name="Pais")
	private PaisEdm pais = null;
	
	@EdmProperty(name = "Nombre", nullable = false)
	private String nombre = null;
	
	public ProvinciaEdm() {}

	public ProvinciaEdm(Integer id, PaisEdm pais, String nombre) {
		super();
		this.id = id;
		this.paisId = pais.getId();
		this.pais = pais;
		this.nombre = nombre;
	}
	
	public ProvinciaEdm(ProvinciaEntity provinciaEntity) {
		this(provinciaEntity.getId(), new PaisEdm(provinciaEntity.getPais()), provinciaEntity.getNombre());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public PaisEdm getPais() {
		return pais;
	}

	public void setPais(PaisEdm pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paisId == null) ? 0 : paisId.hashCode());
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
		ProvinciaEdm other = (ProvinciaEdm) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (paisId == null) {
			if (other.paisId != null)
				return false;
		} else if (!paisId.equals(other.paisId))
			return false;
		return true;
	}

}
