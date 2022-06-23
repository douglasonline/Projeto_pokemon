package com.desafio.demorest;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("seleciona")
public class Seleciona_o_usuario { 
	
    PokemonDAO pokem = new PokemonDAO();
    List<Object> Nome_na_lista = new ArrayList<>();
	
    @GET
    public List<Object> getPoke() {
    	
    return null;
    	
    }
    
	@GET
	@Path("pokemon/{num}")
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Object> getPokemon(@PathParam("num") String num) {	
		
		Nomepokemon nomepokemon = new Nomepokemon();
		nomepokemon.setPokemon(pokem.selecioneUsuario(num)); 
		Nome_na_lista.add(nomepokemon); 
		
		return Nome_na_lista; 
			
		
	} 

}
