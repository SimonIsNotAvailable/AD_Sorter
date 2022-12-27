import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final List<Item> unsortedItems = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Reading...");

        readResources();
        Comparator<Item> comparator = Comparator.comparing(Item::getType);
//        comparator = comparator.thenComparing(Comparator.comparing(person -> person.de));

        System.out.println("sort...");
        unsortedItems.sort(comparator);
        showList();

        System.out.println("...bye");
    }

    private static void readResources() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                unsortedItems.add(Item.parseItem(line));
                line = br.readLine();
            }
            showList();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    private static void showList() {
        for(Item a : unsortedItems) {
            System.out.println(a);
        }
    }
}