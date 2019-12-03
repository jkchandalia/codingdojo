
public abstract class AbstractPokemon implements PokemonInterface {
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon = new Pokemon(name, health, type);
		return pokemon;
	}
	public String pokemonInfo(Pokemon p) {
		String output = p.getName() +", "+p.getHealth()+", "+p.getType();
		return output;
	}
}
