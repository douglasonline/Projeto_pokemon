package com.desafio.demorest;

import java.util.List;

public class Pokemon3 {
	
    private int id;
	
    private String num;
	
	private String name;
	
	private String img;
	
	private List<Object> type;
	
	private String height;
	
	private String weight;
	
	private String candy;
	
	private String egg;
	
	private double spawn_chance;
	
	private double avg_spawns;
	
	private String spawn_time;
	
	private List<Object> multipliers;
	
	private List<Object> weaknesses;
	
	private List<Object> prev_evolution;
	
	public Pokemon3(int id, String num, String name, String img, List<Object> type, String height, String weight,
			String candy, String egg, double spawn_chance, double avg_spawns, String spawn_time,
			List<Object> multipliers, List<Object> weaknesses, List<Object> prev_evolution) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.img = img;
		this.type = type;
		this.height = height;
		this.weight = weight;
		this.candy = candy;
		this.egg = egg;
		this.spawn_chance = spawn_chance;
		this.avg_spawns = avg_spawns;
		this.spawn_time = spawn_time;
		this.multipliers = multipliers;
		this.weaknesses = weaknesses;
		this.prev_evolution = prev_evolution;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

    
	public List<Object> getType() {
		return type;
	}
	
	public void setType(List<Object> type) {
		this.type = type;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCandy() {
		return candy;
	}

	public void setCandy(String candy) {
		this.candy = candy;
	}

	public String getEgg() {
		return egg;
	}

	public void setEgg(String egg) {
		this.egg = egg;
	}

	public double getSpawn_chance() {
		return spawn_chance;
	}

	public void setSpawn_chance(double spawn_chance) {
		this.spawn_chance = spawn_chance;
	}

	public double getAvg_spawns() {
		return avg_spawns;
	}

	public void setAvg_spawns(double avg_spawns) {
		this.avg_spawns = avg_spawns;
	}

	public String getSpawn_time() {
		return spawn_time;
	}

	public void setSpawn_time(String spawn_time) {
		this.spawn_time = spawn_time;
	}

	public List<Object> getMultipliers() {
		return multipliers;
	}

	public void setMultipliers(List<Object> multipliers) {
		this.multipliers = multipliers;
	}

	public List<Object> getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(List<Object> weaknesses) {
		this.weaknesses = weaknesses;
	}

	public List<Object> getPrev_evolution() {
		return prev_evolution;
	}
	
	public void setPrev_evolution(List<Object> prev_evolution) {
		this.prev_evolution = prev_evolution;
	}

	

}