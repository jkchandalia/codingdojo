import java.util.ArrayList; 

public class Pokedex extends AbstractPokemon {
	ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();
	public void listPokemon() {
		for (Pokemon p:myPokemons) {
			System.out.println(pokemonInfo(p));
		}
		
	}
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p = super.createPokemon(name, health, type);
		myPokemons.add(p);
		return p;
	}

}
