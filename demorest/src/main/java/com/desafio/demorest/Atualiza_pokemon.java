package com.desafio.demorest;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("atualiza")
public class Atualiza_pokemon {
	
	PokemonRepository pokem = new PokemonRepository();
	
    @GET
    public List<Object> getPoke() {
    	
    return null;
    	
    }
    
    @PUT
	@Path("pokemon/{num}")
	@Produces(MediaType.APPLICATION_JSON)  
	public String getPokemon(String a1, @PathParam("num") String num) throws Exception {	   
		 
		return pokem.Atualizar(a1, num);
			
		
	} 

}
