import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService 
{
    public static String readFileString(String fileName)
    {
        try
        {
            
            Path paths = Paths.get(fileName);
            String file = Files.readString(paths,StandardCharsets.UTF_8);

            return file;
        }catch(Exception e)
        {
            return null;
        }    

    }
}