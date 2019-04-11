package com.hbt.semillero.servicios;





import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

@Path("/ServiciosRest")
public class ServiciosRest {
	
	@EJB
	private IConsultasBeanLocal consultasBean;
	
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List <MarcaDTO> consultarMarcas(){
		List <Marca> marcas = consultasBean.consultarMarcas();
		List <MarcaDTO> retorno = new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);	
		}
		return retorno;
		
	}
	
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List <LineaDTO> consultarLineas(@QueryParam(value = "idMarca") Long idMarca){
		
		List <Linea> lineas = consultasBean.consultarLineas(idMarca);
		
		List<LineaDTO> retorno = new ArrayList<>();
		
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setNombre(linea.getNombre());
			lineaDTO.setCilindraje(linea.getCilindraje());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);	
		}
		return retorno;
		
	}
	
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO){
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
			
			
		} catch (Exception e) {
			retorno.setExitoso(true);
			retorno.setMensajeError("No se pudo ingresar la persona");
		}
		return retorno;
		 
	}
	
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public List <PersonaDTO> consultarPersona(@QueryParam(value = "tipoIdentificacion") String tipoIdentificacion ,
			@QueryParam(value = "numeroIdentificacion") String numeroIdentificacion){
		
		List <Persona> personas = consultasBean.consultarPersona(tipoIdentificacion, numeroIdentificacion);
		
		List<PersonaDTO> retorno = new ArrayList<>();
		
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setEdad(persona.getEdad());
			
			retorno.add(personaDTO);	
		}
		return retorno;
		
	}
	
	
	private MarcaDTO construirMarcaDTO(Marca marca) {
		
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
	
	

}
