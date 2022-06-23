package com.desafio.demorest;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("paginas")
public class Pokemons_por_paginas {
	
	PokemonDAO pokem = new PokemonDAO();
    List<Object> Nome_na_lista = new ArrayList<>();
	
    @GET
    public List<Object> getPoke() {
    	
    return null;
    	
    }
    
	@GET
	@Path("pokemons/{pagina}/{quantidade}") 
	@Produces(MediaType.APPLICATION_JSON)  
	public List<Object> getPokemon(@PathParam("pagina") int pagina, @PathParam("quantidade") int quantidade) {	
		
		Nomepokemon nomepokemon = new Nomepokemon();
		nomepokemon.setPokemon(pokem.paginas_pokemons(quantidade, pagina)); 
		Nome_na_lista.add(nomepokemon); 
		
		return Nome_na_lista; 
			
		
	} 

}
