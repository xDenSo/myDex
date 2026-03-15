import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Pokemon oder PokeDex Nummer: ");
        String name = myScanner.nextLine();
        myScanner.close();
        Pokemon pokemon = PokemonService.getPokemon(name);
        System.out.println("name: " + pokemon.name);
        System.out.println("id: " + "#" + pokemon.id);
        System.out.println("type: " + pokemon.type);
        System.out.println("height: " + pokemon.height / 10 + "m");
        System.out.println("weight: " + (pokemon.weight * 0.1) + "kg");
        
        
    }
}
