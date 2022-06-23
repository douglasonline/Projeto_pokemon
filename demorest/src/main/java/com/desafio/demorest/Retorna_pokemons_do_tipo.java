package com.desafio.demorest;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("tipo")
public class Retorna_pokemons_do_tipo {
	
	
	PokemonDAO pokem = new PokemonDAO();
    List<Object> Nome_na_lista = new ArrayList<>();
	
    @GET
    public List<Object> getPoke() {
    	
    return null;
    	
    }
    
	@GET
	@Path("pokemons/type") 
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Object> getPokemon() {	
		
		Nomepokemon nomepokemon = new Nomepokemon();
		nomepokemon.setPokemon(pokem.retorna_pokemons_do_tipo()); 
		Nome_na_lista.add(nomepokemon); 
		
		return Nome_na_lista; 
			
		
	}

}
