//import java.util.Scanner;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("[1] PokeDex " + '\n' + "[2] Typechart" + '\n' +  "[3] Beenden" );
        int number = myScanner.nextInt();
        myScanner.nextLine();
        
        switch(number)
        {
            case 1:
                
                System.out.print("Pokemon oder PokeDex Nummer: ");
                String pname = myScanner.nextLine();
                Pokemon pokemon = PokemonService.getPokemon(pname);
                System.out.println("name: " + pokemon.name);
                System.out.println("id: " + "#" + pokemon.id);
                System.out.println("type: " + pokemon.type);
                System.out.println("height: " + pokemon.height / 10 + "m");
                System.out.println("weight: " + (pokemon.weight * 0.1) + "kg");
                break;
                
            case 2:
                System.out.print("Typ des Pokemon: ");
                String type = myScanner.nextLine();
                Types poketype =TypesService.getPokeTypes(type);
                System.out.println("double damage " + poketype.effective);
                System.out.println("half damage: " + poketype.weak);
                System.out.println("immune: " + poketype.immune);
                break;
            case 3:
                System.out.print("Closed"); 
                break;
            default:
                System.out.print("Ungültige Eingabe");
        }
        myScanner.close();
    }
}
    