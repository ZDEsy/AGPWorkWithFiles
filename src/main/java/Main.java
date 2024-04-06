import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Task 1
        /*Poem poem = new Poem();
        System.out.println("Zadej cestu k vstupnímu souboru: ");
        poem.inPathInput = sc.nextLine();
        System.out.println("Zadej cestu k výstupnímu souboru: ");
        poem.outPathInput = sc.nextLine();
        poem.ReadFile();*/

        //Task 2
        NameDays nameDays = new NameDays();
        System.out.println("Dnes je: " + nameDays.currentDate);
        System.out.print("Svátek má: ");
        nameDays.ReturnArray();
        System.out.println(nameDays.TodaysName());
        System.out.print("Zadej své jméno: ");
        nameDays.nameInput = sc.nextLine();
        System.out.println("Máš svátek " + nameDays.SearchName());
    }
}
