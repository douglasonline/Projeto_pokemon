Esse projeto foi criado utilizando o Tomcat v10.0 e a IDE Eclipse java EE e o Banco de dados utilizado foi o MySQL e java JDK 11

Após adicionar o projeto no Eclipse acesse Server e adicione o Tomcat


Insere um novo pokemon:

POST "pokemon"

Endereço: http://localhost:8080/demorest/webapi/pokemon

Exemplo de JSON:

{
    "id": 5,
    "num": "005",
    "name": "Ivysaur",
    "img": "http://www.serebii.net/pokemongo/pokemon/002.png",
    "type": [
      "Grass",
      "Poison"
    ],
    "height": "0.99 m",
    "weight": "13.0 kg",
    "candy": "Bulbasaur Candy",
    "candy_count": 100,
    "egg": "Not in Eggs",
    "spawn_chance": 0.042,
    "avg_spawns": 4.2,
    "spawn_time": "07:00",
    "multipliers": [
      1.2,
      1.6
    ],
    "weaknesses": [
      "Fire",
      "Ice",
      "Flying",
      "Psychic"
    ],
    "prev_evolution": [{
      "num": "001",
      "name": "Bulbasaur"
    }],
    "next_evolution": [{
      "num": "003",
      "name": "Venusaur"
    }]
  }
  
  
  Retornar os dados do pokemon com o número passado, campo "num"
  
  •	Método GET "pokemon/NUMERO_DO_POKEMON" 
  
  Endereço: http://localhost:8080/demorest/webapi/seleciona/pokemon/003
  
  
  
  Atualiza o pokemon com o número (campo "num") passado usando os dados do pokemon informados no body da requisição
  
  •	Método PUT "pokemon/NUMERO_DO_POKEMON"  
  
  Endereço: http://localhost:8080/demorest/webapi/atualiza/pokemon/003
  
  Exemplo de JSON:
  
  {
    "id": 3,
    "num": "003",
    "name": "charizard",
    "img": "http://www.serebii.net/pokemongo/pokemon/002.png",
    "type": [
      "Grass",
      "Poison"
    ],
    "height": "0.99 m",
    "weight": "13.0 kg",
    "candy": "Bulbasaur Candy",
    "candy_count": 100,
    "egg": "Not in Eggs",
    "spawn_chance": 0.042,
    "avg_spawns": 4.2,
    "spawn_time": "07:00",
    "multipliers": [
      1.2,
      1.6
    ],
    "weaknesses": [
      "Fire",
      "Ice",
      "Flying",
      "Psychic"
    ],
    "prev_evolution": [{
      "num": "001",
      "name": "Bulbasaur"
    }],
    "next_evolution": [{
      "num": "003",
      "name": "Venusaur"
    }]
  }
  
  
  
  Exclui o pokemon que possui o número (campo "num") informado
  
  •	Metodo DELETE "pokemon/NUMERO_DO_POKEMON" 
  
  Endereço: http://localhost:8080/demorest/webapi/excluir/pokemon/003
  
  
  Retorna todos os pokemons
  
  •	Metodo GET "pokemons"
  
  Endereço: http://localhost:8080/demorest/webapi/pokemons
  
  
  
  Divide os pokemons em páginas 
  
  •	Metodo GET "pokemons/PAGINA/QUANTIDADE"
  
  Endereço: http://localhost:8080/demorest/webapi/paginas/pokemons/2/2
  
  
  
  Retorna os pokemons do tipo (campo 'type')
  
  •	Metodo GET "pokemons/TIPO_DO_POKEMON"
  
  Endereço: http://localhost:8080/demorest/webapi/tipo/pokemons/type
  
  
  
  
  
  
