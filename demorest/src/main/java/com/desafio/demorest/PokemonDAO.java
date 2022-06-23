package com.desafio.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonDAO {
	
	
	List<Object> Nome_na_lista = new ArrayList<>();
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/tabelas_pokemon";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	// define instruções sql
	
	private static final String SELECT_ALL_USERS = "select * from pokemon";
	private static final String SELECT_ALL_USERS2 = "select * from pokemon2";
	private static final String SELECT_ALL_USERS3 = "select * from pokemon3";
	private static final String SELECT_ALL_USERS4 = "select * from pokemon4";
	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO pokemon" + "  (id, num, name, img, type, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, multipliers, weaknesses, next_evolution) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String INSERT_USERS_SQL2 = "INSERT INTO pokemon2" + "  (id, num, name, img, type, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, multipliers, weaknesses, prev_evolution, next_evolution) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String INSERT_USERS_SQL3 = "INSERT INTO pokemon3" + "  (id, num, name, img, type, height, weight, candy, egg, spawn_chance, avg_spawns, spawn_time, multipliers, weaknesses, prev_evolution) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select * from pokemon2 where num =?";
	
	private static final String UPDATE_USERS_SQL = "update pokemon2 set id = ?, num= ?, name =?, img= ?, type= ?, height= ?, weight= ?, candy= ?, candy_count= ?, egg= ?, spawn_chance= ?, avg_spawns= ?, spawn_time= ?, multipliers= ?, weaknesses= ?, prev_evolution= ?, next_evolution= ? where num = ?;";
	
	private static final String DELETE_USERS_SQL = "delete from pokemon2 where num = ?;";
	
	private static final String PAGINAS = "SELECT * FROM pokemon2 LIMIT ?, ?;";
	

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// Bloco de captura TODO gerado automaticamente
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// Bloco de captura gerado automaticamente TODO
			e.printStackTrace();
		}
		return connection;
	}
	
	
	
	public List<Object> selecionarPokemon() {	
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) { 
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        int candy_count = rs.getInt("candy_count");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        int avg_spawns = rs.getInt("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		        
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        List<Object> Dados_multipliers_list = new ArrayList<>();
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list.add(per_multipliers); 
		        	
		        }
		        
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        String next_evolution = rs.getString("next_evolution");
		        
		        String[] dividir_por_virgula = next_evolution.split(",");
		        
		        List<Object> Dados_next_evolution_list = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula[i]);
		    		poNext_evolution2.setName(dividir_por_virgula[i + 1]);
		    		
		    		//System.out.println("teste: " + dividir_por_virgula[i]);
		    		//System.out.println("teste2: " + dividir_por_virgula[i + 1]);
		        	
		    		Dados_next_evolution_list.add(poNext_evolution2);
		            
		    		
		        }
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon(id, num, name, img, Dados_type_list, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list, Dados_weaknesses_list, Dados_next_evolution_list));
		        
		        
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		selecionarPokemon2();
		selecionarPokemon3();
		selecionarPokemon4();
		
		return Nome_na_lista;
		
	}
	
	
	
	public List<Object> selecionarPokemon2() {
		
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS2);) {
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        int candy_count = rs.getInt("candy_count");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        double avg_spawns = rs.getDouble("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        
                List<Object> Dados_multipliers_list = new ArrayList<>();
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list.add(per_multipliers); 
		        	
		        }
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        
                String prev_evolution = rs.getString("prev_evolution");
		        
		        String[] dividir_por_virgula_par1 = prev_evolution.split(",");
		        
		        List<Object> Dados_prev_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula_par1.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula_par1[i]);
		    		poNext_evolution2.setName(dividir_por_virgula_par1[i + 1]);
		    		
		        	
		    		Dados_prev_evolution_list2.add(poNext_evolution2);
		            
		    		
		        }
		        
		        
		        
		        String next_evolution = rs.getString("next_evolution");
		        
		        String[] dividir_por_virgula = next_evolution.split(",");
		        
		        List<Object> Dados_next_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula[i]);
		    		poNext_evolution2.setName(dividir_por_virgula[i + 1]);
		    		
		        	
		    		Dados_next_evolution_list2.add(poNext_evolution2); 
		            
		    		
		        }
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon2(id, num, name, img, Dados_type_list, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list, Dados_weaknesses_list, Dados_prev_evolution_list2,  Dados_next_evolution_list2));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return null; 
	}
	
	
	
	
	
	public List<Object> selecionarPokemon3() {
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS3);) {
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        double avg_spawns = rs.getDouble("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		        
		        List<Object> Dados_multipliers_list_por_causa_do_nulo = new ArrayList<>();
		         
		        if(multipliers.equals("0")) { 
		        	
		        	Dados_multipliers_list_por_causa_do_nulo.add(null); 
		        	
		        }
		        
		        else {
		        	
		        
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list_por_causa_do_nulo.add(per_multipliers); 
		        	
		        }
		        
		        }
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        
                String prev_evolution = rs.getString("prev_evolution");
		        
		        String[] dividir_por_virgula_par1 = prev_evolution.split(",");
		        
		        List<Object> Dados_prev_evolution_list3 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula_par1.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula_par1[i]);
		    		poNext_evolution2.setName(dividir_por_virgula_par1[i + 1]);
		    		
		        	
		    		Dados_prev_evolution_list3.add(poNext_evolution2);
		            
		    		
		        }
		        
		        
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon3(id, num, name, img, Dados_type_list, height, weight, candy, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list_por_causa_do_nulo, Dados_weaknesses_list, Dados_prev_evolution_list3));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return null; 
	}	
	
	
	
	
	public List<Object> selecionarPokemon4() {
		
		
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS4);) {
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        int candy_count = rs.getInt("candy_count");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        double avg_spawns = rs.getDouble("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		         
		        
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        
		        List<Object> Dados_multipliers_list = new ArrayList<>();
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list.add(per_multipliers); 
		        	
		        }
		        
		        
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        
                String next_evolution = rs.getString("next_evolution");
		        
		        String[] dividir_por_virgula_par1 = next_evolution.split(",");
		        
		        List<Object> Dados_next_evolution_list4 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula_par1.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula_par1[i]);
		    		poNext_evolution2.setName(dividir_por_virgula_par1[i + 1]);
		    		
		        	
		    		Dados_next_evolution_list4.add(poNext_evolution2);
		            
		    		
		        }
		        
		        
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon4(id, num, name, img, Dados_type_list, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list, Dados_weaknesses_list, Dados_next_evolution_list4));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return null; 
	}
	
	
	
	public void insertUser(int id, String num, String name, String img, String type, String height, String weight, String candy, int candy_count, String egg, Double spawn_chance, int avg_spawns, String spawn_time, String multipliers, String weaknesses, String next_evolution) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// A instrução try-with-resource fechará automaticamente a conexão.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement_pokemon = connection.prepareStatement(INSERT_USERS_SQL)) { 
			preparedStatement_pokemon.setInt(1, id);
			preparedStatement_pokemon.setString(2, num);
			preparedStatement_pokemon.setString(3, name);
			preparedStatement_pokemon.setString(4, img);
			preparedStatement_pokemon.setObject(5, type);
			preparedStatement_pokemon.setString(6, height);
			preparedStatement_pokemon.setString(7, weight);
			preparedStatement_pokemon.setString(8, candy);
			preparedStatement_pokemon.setInt(9, candy_count);
			preparedStatement_pokemon.setString(10, egg);
			preparedStatement_pokemon.setDouble(11, spawn_chance);
			preparedStatement_pokemon.setInt(12, avg_spawns);
			preparedStatement_pokemon.setString(13, spawn_time);
			preparedStatement_pokemon.setObject(14, multipliers);
			preparedStatement_pokemon.setObject(15, weaknesses);
			preparedStatement_pokemon.setObject(16, next_evolution);
			System.out.println(preparedStatement_pokemon);
			preparedStatement_pokemon.executeUpdate();
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		
	}
	
	
	public void insertUser2(int id, String num, String name, String img, String type, String height, String weight, String candy, int candy_count, String egg, Double spawn_chance, Double avg_spawns, String spawn_time, String multipliers, String weaknesses, String prev_evolution, String next_evolution) throws SQLException {
		System.out.println(INSERT_USERS_SQL2);
		// A instrução try-with-resource fechará automaticamente a conexão.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL2)) { 
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, num);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, img);
			preparedStatement.setObject(5, type);
			preparedStatement.setString(6, height);
			preparedStatement.setString(7, weight);
			preparedStatement.setString(8, candy);
			preparedStatement.setInt(9, candy_count);
			preparedStatement.setString(10, egg);
			preparedStatement.setDouble(11, spawn_chance);
			preparedStatement.setDouble(12, avg_spawns);
			preparedStatement.setString(13, spawn_time);
			preparedStatement.setObject(14, multipliers);
			preparedStatement.setObject(15, weaknesses);
			preparedStatement.setObject(16, prev_evolution);
			preparedStatement.setObject(17, next_evolution);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		
	}
	
	
	public void insertUser3(int id, String num, String name, String img, String type, String height, String weight, String candy, String egg, Double spawn_chance, Double avg_spawns, String spawn_time, String multipliers, String weaknesses, String next_evolution) throws SQLException {
		System.out.println(INSERT_USERS_SQL3);
		// A instrução try-with-resource fechará automaticamente a conexão.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL3)) { 
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, num);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, img);
			preparedStatement.setObject(5, type);
			preparedStatement.setString(6, height);
			preparedStatement.setString(7, weight);
			preparedStatement.setString(8, candy);
			preparedStatement.setString(9, egg);
			preparedStatement.setDouble(10, spawn_chance);
			preparedStatement.setDouble(11, avg_spawns);
			preparedStatement.setString(12, spawn_time);
			preparedStatement.setObject(13, multipliers);
			preparedStatement.setObject(14, weaknesses);
			preparedStatement.setObject(15, next_evolution);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		
	}
	
	
	public List<Object> selecioneUsuario(String num) {
		
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, num);
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String dado_num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        int candy_count = rs.getInt("candy_count");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        double avg_spawns = rs.getDouble("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        
                List<Object> Dados_multipliers_list = new ArrayList<>();
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list.add(per_multipliers); 
		        	
		        }
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        
                String prev_evolution = rs.getString("prev_evolution");
		        
		        String[] dividir_por_virgula_par1 = prev_evolution.split(",");
		        
		        List<Object> Dados_prev_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula_par1.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula_par1[i]);
		    		poNext_evolution2.setName(dividir_por_virgula_par1[i + 1]);
		    		
		        	
		    		Dados_prev_evolution_list2.add(poNext_evolution2);
		            
		    		
		        }
		        
		        
		        
		        String next_evolution = rs.getString("next_evolution");
		        
		        String[] dividir_por_virgula = next_evolution.split(",");
		        
		        List<Object> Dados_next_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula[i]);
		    		poNext_evolution2.setName(dividir_por_virgula[i + 1]);
		    		
		        	
		    		Dados_next_evolution_list2.add(poNext_evolution2); 
		            
		    		
		        }
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon2(id, dado_num, name, img, Dados_type_list, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list, Dados_weaknesses_list, Dados_prev_evolution_list2,  Dados_next_evolution_list2));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return Nome_na_lista; 
	}
	
	
	public String atualizarusuario(int id, String num, String name, String img, String type, String height, String weight, String candy, int candy_count, String egg, Double spawn_chance, Double avg_spawns, String spawn_time, String multipliers, String weaknesses, String prev_evolution, String next_evolution, String parametro_num) throws SQLException {
		System.out.println(UPDATE_USERS_SQL);
		
		// A instrução try-with-resource fechará automaticamente a conexão.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) { 
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, num);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, img);
			preparedStatement.setObject(5, type);
			preparedStatement.setString(6, height);
			preparedStatement.setString(7, weight);
			preparedStatement.setString(8, candy);
			preparedStatement.setInt(9, candy_count);
			preparedStatement.setString(10, egg);
			preparedStatement.setDouble(11, spawn_chance);
			preparedStatement.setDouble(12, avg_spawns);
			preparedStatement.setString(13, spawn_time);
			preparedStatement.setObject(14, multipliers);
			preparedStatement.setObject(15, weaknesses); 
			preparedStatement.setObject(16, prev_evolution);
			preparedStatement.setObject(17, next_evolution);
			preparedStatement.setString(18, parametro_num); 
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		return null;
	}
	
	
	public String excluirdado(String num) throws SQLException {
		System.out.println(DELETE_USERS_SQL);
		
		// A instrução try-with-resource fechará automaticamente a conexão.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
			
			preparedStatement.setString(1, num);
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		return "Dados excluidos"; 
	}
	
	
	
       public List<Object> paginas_pokemons(int quantidade, int pagina) {
		
		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(PAGINAS);) {
			System.out.println(preparedStatement);
			preparedStatement.setInt(1, quantidade);
			preparedStatement.setInt(2, pagina); 
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String num = rs.getString("num");
				String name = rs.getString("name");
				String img = rs.getString("img");
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        String height = rs.getString("height");
		        String weight = rs.getString("weight");
		        String candy = rs.getString("candy");
		        int candy_count = rs.getInt("candy_count");
		        String egg = rs.getString("egg");
		        double spawn_chance = rs.getDouble("spawn_chance");
		        double avg_spawns = rs.getDouble("avg_spawns");
		        String spawn_time = rs.getString("spawn_time");
		        String multipliers = rs.getString("multipliers");
		        String[] employeeNamesSplit2 = multipliers.split(","); //Nomes de divisão
		        
                List<Object> Dados_multipliers_list = new ArrayList<>();
		        
		        for (int i2 = 0; i2 < employeeNamesSplit2.length; i2++) {
		        	
		        	double per_multipliers = Double.parseDouble(employeeNamesSplit2[i2]); 
		        	Dados_multipliers_list.add(per_multipliers); 
		        	
		        }
		        
		        String weaknesses = rs.getString("weaknesses");
		        String[] employeeNamesSplit3 = weaknesses.split(",");  //Nomes de divisão
		        ArrayList<Object> Dados_weaknesses_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit3)); 
		        
                String prev_evolution = rs.getString("prev_evolution");
		        
		        String[] dividir_por_virgula_par1 = prev_evolution.split(",");
		        
		        List<Object> Dados_prev_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula_par1.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula_par1[i]);
		    		poNext_evolution2.setName(dividir_por_virgula_par1[i + 1]);
		    		
		        	
		    		Dados_prev_evolution_list2.add(poNext_evolution2);
		            
		    		
		        }
		        
		        
		        
		        String next_evolution = rs.getString("next_evolution");
		        
		        String[] dividir_por_virgula = next_evolution.split(",");
		        
		        List<Object> Dados_next_evolution_list2 = new ArrayList<>();
		        
		        for (int i = 0; i < dividir_por_virgula.length - 1; i+=2) {
		        	
		        	PoNext_evolution poNext_evolution2 = new PoNext_evolution(); 
		    		poNext_evolution2.setNum(dividir_por_virgula[i]);
		    		poNext_evolution2.setName(dividir_por_virgula[i + 1]);
		    		
		        	
		    		Dados_next_evolution_list2.add(poNext_evolution2); 
		            
		    		
		        }
		        
		        //ArrayList<String> Dados_next_evolution_list = new ArrayList<String>(Arrays.asList(employeeNamesSplit4));
		        
		        Nome_na_lista.add(new Pokemon2(id, num, name, img, Dados_type_list, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time, Dados_multipliers_list, Dados_weaknesses_list, Dados_prev_evolution_list2,  Dados_next_evolution_list2));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return Nome_na_lista; 
	}
       
       
       public List<Object> retorna_pokemons_do_tipo() {
   		
   		
		// Etapa 1: estabelecendo uma conexão
		
		try (Connection connection = getConnection();

				// Passo 2:Criar uma declaração usando o objeto de conexão
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS2);) {
			System.out.println(preparedStatement);
			
			// Etapa 3: Executar a consulta ou atualizar a consulta
			
			ResultSet rs = preparedStatement.executeQuery();

			// Etapa 4: Processe o objeto ResultSet.
			
			while (rs.next()) {
				
				String type = rs.getString("type");
				String[] employeeNamesSplit = type.split(","); //Nomes de divisão
		        ArrayList<Object> Dados_type_list = new ArrayList<Object>(Arrays.asList(employeeNamesSplit)); 
		        
		        Nome_na_lista.add(new Tipo_type(Dados_type_list));
			}
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		return Nome_na_lista; 
	}
	
	
	
	
}


