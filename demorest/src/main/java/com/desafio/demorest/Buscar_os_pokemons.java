package com.desafio.demorest;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("pokemons")
public class Buscar_os_pokemons {
	
	
	PokemonRepository pokem = new PokemonRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Object> getPokemon() {
		
		System.out.println("pokemon ligou");
		
		return pokem.getPokemon();
		
	}
	

}


