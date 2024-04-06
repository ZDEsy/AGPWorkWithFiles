import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

public class Poem {
    public String inPathInput;
    public String outPathInput;

    public void ReadFile()
    {
        Path inPath = Path.of(System.getProperty("user.home"),"IdeaProjects\\FilesAGP\\src\\main\\resources\\" + inPathInput);
        Path outPath = Path.of(outPathInput);
        try{
            List<String> lines = Files.readAllLines(inPath);
            Files.writeString(outPath, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            Random rand = new Random();
            int dice;
            int j = 0;
            while(j < 20)
            {
                dice = rand.nextInt(lines.size());
                Files.writeString(outPath, lines.get(dice) + System.lineSeparator(), StandardOpenOption.APPEND);
                j++;
                lines.remove(dice);
            }
        }
        catch(Exception e)
        {
            System.out.println("Soubor neexistuje");
        }
    }
}