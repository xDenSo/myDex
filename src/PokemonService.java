import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class PokemonService 
{
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public static String getURLString(String name)
    {   
        String url = BASE_URL + name.toLowerCase(); 
        return url;
    }

    private static Pokemon getData(String link)
    {
        try
        {  
        //API Client
            HttpClient client = HttpClient.newHttpClient();

            //API request
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

            //API async 
            String responseBody = client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

            JSONObject jsonObject = new JSONObject(responseBody);
            
            Pokemon pokemon = new Pokemon();
            pokemon.name = jsonObject.getString("name");
            pokemon.id = jsonObject.getInt("id");
            pokemon.weight = jsonObject.getDouble("weight");
            pokemon.height = jsonObject.getDouble("height");
            JSONArray typesArray  = jsonObject.getJSONArray("types");
            
            pokemon.type = new ArrayList<>();
            for(int i = 0; i < typesArray.length(); i++)
            {
                JSONObject firstResult = typesArray.getJSONObject(i);
                JSONObject type = firstResult.getJSONObject("type");
                pokemon.type.add(type.getString("name"));
                
            }
            
            
            
            

            return pokemon;
        }catch(Exception e)
        {
            return null;
        }
    }

    public static Pokemon getPokemon(String name)
    {
        
        String url = getURLString(name);
        //System.out.println(url);
        Pokemon pokemon = getData(url);
        return pokemon;

    }

}
