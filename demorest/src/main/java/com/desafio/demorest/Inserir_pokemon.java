package com.desafio.demorest;


import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("pokemon")
public class Inserir_pokemon {
	
	PokemonRepository poke = new PokemonRepository();
	
	@POST
	public String createPokemon(String a1) throws Exception { 
		
		return poke.create(a1); 
		
	}

}
