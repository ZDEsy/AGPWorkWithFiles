import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class NameDays {
    LocalDate currentDate = LocalDate.now();
    String[][] days = new String[12][31];
    String nameInput;

    public void ReturnArray()
    {
        Path input = Path.of(System.getProperty("user.home"), "IdeaProjects\\FilesAGP\\src\\main\\resources\\svatky.txt");
        try
        {
            List<String> lines = Files.readAllLines(input);
            int i = 0;
            int j = 0;
            for(String g : lines)
            {
                if(!g.isEmpty())
                {
                    days[i][j] = g;
                    j++;
                }
                else
                {
                    i++;
                    j = 0;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String TodaysName()
    {
        String[] timeSep = currentDate.toString().split("-");
        int[] timeInt = new int[3];
        for(int i = 0; i < timeSep.length; i++)
        {
            timeInt[i] = Integer.parseInt(timeSep[i]);
        }
        return days[timeInt[1]-1][timeInt[2]-1];
    }

    public String SearchName()
    {
        nameInput = nameInput.substring(0,1).toUpperCase() + nameInput.substring(1);
        String dateOfDay = null;
        int i = 0;
        int j = 0;
        while(dateOfDay == null)
        {
            try
            {
                if(days[i][j].contains(nameInput))
                {
                    dateOfDay = j+1 + ". " + Integer.parseInt(String.valueOf(i+1)) + ".";
                }
                else
                {
                    j++;
                }
            }
            catch (Exception e)
            {
                if(i > 12)
                {
                    return "{Špatně zadané jméno}";
                }
                else
                {
                    i++;
                    j = 0;
                }
            }

        }
        return dateOfDay;
    }
}
