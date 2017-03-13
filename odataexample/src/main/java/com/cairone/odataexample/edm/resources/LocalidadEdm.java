package com.cairone.odataexample.edm.resources;

import com.cairone.odataexample.EntityServiceRegistar;
import com.sdl.odata.api.edm.annotations.EdmEntity;
import com.sdl.odata.api.edm.annotations.EdmEntitySet;
import com.sdl.odata.api.edm.annotations.EdmProperty;

@EdmEntity(name = "Localidad", key = { "paisId", "provinciaId", "localidadId" }, namespace = EntityServiceRegistar.NAME_SPACE, containerName = EntityServiceRegistar.CONTAINER_NAME)
@EdmEntitySet("Localidades")
public class LocalidadEdm {

	@EdmProperty(nullable = false)
	private Integer paisId = null;
	
	@EdmProperty(nullable = false)
	private Integer provinciaId = null;
	
	@EdmProperty(nullable = false)
	private Integer localidadId = null;
	
	@EdmProperty(nullable = false)
	private String nombre = null;
	
	@EdmProperty(nullable = false)
	private Integer cp = null;
	
	@EdmProperty(nullable = false)
	private Integer prefijo = null;
	
}
