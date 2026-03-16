import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TypesService 
{
    private static final String fileName = "resources/pokemontypes.json";

    public static String getDataString()
    {
        
        String type = FileService.readFileString(fileName);
        
        return type;
    }

    public static Types parse(String name)
    {
        JSONArray jsonArray = new JSONArray(getDataString());
        Types type = new Types();
        type.effective = new ArrayList<>();
        type.immune = new ArrayList<>();
        type.weak = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject firstResult = jsonArray.getJSONObject(i);
                String poketype = firstResult.getString("name");
                

                if(poketype.equals(name))
                    {
                        JSONArray immuneArray = firstResult.getJSONArray("immunes");
                        for(int j = 0; j < immuneArray.length(); j++)
                            {
                                type.immune.add(immuneArray.getString(j));
                            }
                            JSONArray effectiveArray = firstResult.getJSONArray("strengths");
                        for(int j = 0; j < effectiveArray.length(); j++)
                            {
                                type.effective.add(effectiveArray.getString(j));
                            }
                            JSONArray weakArray = firstResult.getJSONArray("weaknesses");
                        for(int j = 0; j < weakArray.length(); j++)
                            {
                                type.weak.add(weakArray.getString(j));
                            }
                        break;

                    }
                
            }
        return type;
    }

    public static Types getPokeTypes(String name)
    {
        Types type = parse(name.toLowerCase());
        return type;

    }
}
 