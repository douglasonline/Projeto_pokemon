package com.desafio.demorest;

import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("excluir")
public class Excluir_pokemon {
	
    PokemonDAO pokem = new PokemonDAO();
	
    @GET
    public List<Object> getPoke() {
    	
    return null;
    	
    }
    
    @DELETE 
	@Path("pokemon/{num}")
	@Produces(MediaType.APPLICATION_JSON)  
	public String getPokemon(@PathParam("num") String num) throws Exception {	   
		 
		return pokem.excluirdado(num);
			
		
	}

}
