package com.desafio.demorest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.*;

public class PokemonRepository {
	
	PokemonDAO pokemList = new PokemonDAO();
	List<Object> poke = new ArrayList<>();  
	List<Object> Nome_na_lista = new ArrayList<>(); 
	
	
	public PokemonRepository() {
		
		Nomepokemon nomepokemon = new Nomepokemon();
		nomepokemon.setPokemon(pokemList.selecionarPokemon());
		poke.add(nomepokemon); 
		
		
		
		
	}
	
	public List<Object> getPokemon(){  
		
		return poke; 
		
		
		
	} 
	
	/* public Pokemon getPokemon(String id) {
		
		for(Pokemon a : poke) {
			
			if(a.getNum()==id) {
				
				return a;
				
			}
				
		}
		
		return null;
	} */

	
	public String create(String a1) throws Exception  { 
		
		System.out.println(a1);
		//pokem.create(a1);
		
		String jsonString;
		
		
		try {
			
			jsonString = a1; //assign your JSON String here
			JSONObject obj = new JSONObject(jsonString);
			
			
			/*if (obj.has("next_evolution")) {
				
				System.out.println("aqui não");
				
				 String num2 = "";
				 String name2 = "";
				 String next_evolution = ""; 
				 
				 int id               = obj.getInt("id"); 
				 String num           = obj.getString("num");
				 String name          = obj.getString("name");
				 String img           = obj.getString("img");
				 String type          = obj.getString("type");
				 String dados_type = type; 
				 dados_type = dados_type.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String height        = obj.getString("height");
				 String weight        = obj.getString("height");
				 String candy         = obj.getString("candy");
				 int candy_count      = obj.getInt("candy_count");
				 String egg           = obj.getString("egg");
				 Double spawn_chance  = obj.getDouble("spawn_chance");
				 int avg_spawns       = obj.getInt("avg_spawns");
				 String spawn_time    = obj.getString("spawn_time");
				 String multipliers   = obj.getString("multipliers");
				 String dados_multipliers = multipliers; 
				 dados_multipliers = dados_multipliers.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String weaknesses    = obj.getString("weaknesses");
				 String dados_weaknesses = weaknesses; 
				 dados_weaknesses = dados_weaknesses.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 
				  JSONArray arr2 = obj.getJSONArray("next_evolution"); // notice that `"posts": [...]`
				  for (int i3 = 0; i3 < arr2.length(); i3++){
						
				   num2     = arr2.getJSONObject(i3).getString("num");
				   name2    = arr2.getJSONObject(i3).getString("name");
				   
				   next_evolution += num2 + "," + name2 + ",";
				  
						
				  }	
				  
				  pokemList.insertUser(id, num, name, img, dados_type, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, dados_multipliers, dados_weaknesses, next_evolution);
				
			} */
			
			
			if (obj.has("prev_evolution")  && obj.has("next_evolution")) {
				
				
				 String num1 = null;
				 String name1 = null;
				 String prev_evolution = null;
				 
				 String num2 = null;
				 String name2 = null;
				 String next_evolution = null; 
				 
				 int id               = obj.getInt("id"); 
				 String num           = obj.getString("num");
				 String name          = obj.getString("name");
				 String img           = obj.getString("img");
				 String type          = obj.getString("type");
				 String dados_type = type; 
				 dados_type = dados_type.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String height        = obj.getString("height");
				 String weight        = obj.getString("height");
				 String candy         = obj.getString("candy");
				 int candy_count      = obj.getInt("candy_count");
				 String egg           = obj.getString("egg");
				 Double spawn_chance  = obj.getDouble("spawn_chance");
				 Double avg_spawns    = obj.getDouble("avg_spawns");
				 String spawn_time    = obj.getString("spawn_time");
				 String multipliers   = obj.getString("multipliers");
				 String dados_multipliers = multipliers; 
				 dados_multipliers = dados_multipliers.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String weaknesses    = obj.getString("weaknesses");
				 String dados_weaknesses = weaknesses; 
				 dados_weaknesses = dados_weaknesses.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				     
				 JSONArray arr = obj.getJSONArray("prev_evolution"); // notice that `"posts": [...]`
				 for (int i = 0; i < arr.length(); i++){
						
				   num1     = arr.getJSONObject(i).getString("num");
				   name1    = arr.getJSONObject(i).getString("name");
				   
				   prev_evolution = num1 + "," + name1;
				  
						
				  }	
				  
				  
				  JSONArray arr2 = obj.getJSONArray("next_evolution"); // notice that `"posts": [...]`
				  for (int i3 = 0; i3 < arr2.length(); i3++){
						
				   num2     = arr2.getJSONObject(i3).getString("num");
				   name2    = arr2.getJSONObject(i3).getString("name");
				   
				   next_evolution = num2 + "," + name2;
				  
						
				  }	
				  
				  pokemList.insertUser2(id, num, name, img, dados_type, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, dados_multipliers, dados_weaknesses, prev_evolution, next_evolution);
				
			}
			
			
			/* if (obj.has("prev_evolution")) {
				
				 String num2 = "";
				 String name2 = "";
				 String prev_evolution = ""; 
				 
				 int id               = obj.getInt("id"); 
				 String num           = obj.getString("num");
				 String name          = obj.getString("name");
				 String img           = obj.getString("img");
				 String type          = obj.getString("type");
				 String dados_type = type; 
				 dados_type = dados_type.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String height        = obj.getString("height");
				 String weight        = obj.getString("height");
				 String candy         = obj.getString("candy");
				 String egg           = obj.getString("egg");
				 Double spawn_chance  = obj.getDouble("spawn_chance");
				 Double avg_spawns    = obj.getDouble("avg_spawns");
				 String spawn_time    = obj.getString("spawn_time");
				 String multipliers   = obj.getString("multipliers");
				 String dados_multipliers = multipliers; 
				 dados_multipliers = dados_multipliers.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String weaknesses    = obj.getString("weaknesses");
				 String dados_weaknesses = weaknesses; 
				 dados_weaknesses = dados_weaknesses.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 
				  JSONArray arr2 = obj.getJSONArray("prev_evolution"); // notice that `"posts": [...]`
				  for (int i3 = 0; i3 < arr2.length(); i3++){
						
				   num2     = arr2.getJSONObject(i3).getString("num");
				   name2    = arr2.getJSONObject(i3).getString("name");
				   
				   prev_evolution += num2 + "," + name2 + ",";
				  
						
				  }	
				  
				  pokemList.insertUser3(id, num, name, img, dados_type, height, weight, candy, egg, spawn_chance, avg_spawns, spawn_time, dados_multipliers, dados_weaknesses, prev_evolution);
				
			} */
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "Dados inseridos";
		
		
		
		
	}
	
	
	
	public String Atualizar(String a1, String parametro_num) throws Exception  { 
		
		
		System.out.println(a1);
		//pokem.create(a1);
		
		String jsonString;
		
		
		try {
			
			jsonString = a1; //assign your JSON String here
			JSONObject obj = new JSONObject(jsonString);
			
			
			if (obj.has("prev_evolution")  && obj.has("next_evolution")) {
				
				 String num1 = null;
				 String name1 = null;
				 String prev_evolution = null;
				 
				 String num2 = null;
				 String name2 = null;
				 String next_evolution = null; 
				 
				 int id               = obj.getInt("id"); 
				 String num           = obj.getString("num");
				 String name          = obj.getString("name");
				 String img           = obj.getString("img");
				 String type          = obj.getString("type");
				 String dados_type = type; 
				 dados_type = dados_type.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String height        = obj.getString("height");
				 String weight        = obj.getString("height");
				 String candy         = obj.getString("candy");
				 int candy_count      = obj.getInt("candy_count");
				 String egg           = obj.getString("egg");
				 Double spawn_chance  = obj.getDouble("spawn_chance");
				 Double avg_spawns    = obj.getDouble("avg_spawns");
				 String spawn_time    = obj.getString("spawn_time");
				 String multipliers   = obj.getString("multipliers");
				 String dados_multipliers = multipliers; 
				 dados_multipliers = dados_multipliers.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				 String weaknesses    = obj.getString("weaknesses");
				 String dados_weaknesses = weaknesses; 
				 dados_weaknesses = dados_weaknesses.replaceAll("\\[", "").replaceAll("\\]","").replaceAll("\"", "");  
				 
				     
				 JSONArray arr = obj.getJSONArray("prev_evolution"); // notice that `"posts": [...]`
				 for (int i = 0; i < arr.length(); i++){
						
				   num1     = arr.getJSONObject(i).getString("num");
				   name1    = arr.getJSONObject(i).getString("name");
				   
				   prev_evolution = num1 + "," + name1;
				  
						
				  }	
				  
				  
				  JSONArray arr2 = obj.getJSONArray("next_evolution"); // notice that `"posts": [...]`
				  for (int i3 = 0; i3 < arr2.length(); i3++){
						
				   num2     = arr2.getJSONObject(i3).getString("num");
				   name2    = arr2.getJSONObject(i3).getString("name");
				   
				   next_evolution = num2 + "," + name2;
				  
						
				  }	
				  
				  pokemList.atualizarusuario(id, num, name, img, dados_type, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, dados_multipliers, dados_weaknesses, prev_evolution, next_evolution, parametro_num);
				
			}
			
					
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "Dados atualizados";
		
		
		
		
	}
	
	
	

}
