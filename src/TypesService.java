public class TypesService 
{
    private static final String fileName = "resources/pokemontypes.json";

    public static String getString()
    {
        
        String type = FileService.readFileString(fileName);
        
        return type;
    }
}
 