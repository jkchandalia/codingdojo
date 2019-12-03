
public class PokemonTest {
	public static void main(String[] args) {
	Pokedex pdex = new Pokedex();
	Pokemon p = pdex.createPokemon("Pikachu",8,"Pokemon");
	Pokemon b = pdex.createPokemon("Bulbasaur", 7, "Burrower");
	b.attackPokemon(p);
	pdex.listPokemon();
}
}