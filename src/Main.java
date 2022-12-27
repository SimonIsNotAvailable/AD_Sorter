import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Main {

    private static final List<Item> unsortedItems = new ArrayList<>();
    private static final List<Item> sortedList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        readResources();
        sort();
    }

    private static void sort() {
        System.out.println("Sorting started..." + "\n");
        Comparator<Item> comparator = Comparator.comparing(Item::getType);
        unsortedItems.sort(comparator);
        List<ItemStandard> standardDetails = new ArrayList<>();
        List<ItemDetail> details = new ArrayList<>();
        List<MaterialItem> materials = new ArrayList<>();
        for(Item i : unsortedItems) {
            switch (i.getType()){
                case DET:
                case SE:
                    details.add((ItemDetail) i);
                     break;
                case MAT:
                    assert i instanceof MaterialItem;
                    materials.add((MaterialItem) i);
                    break;
                case STD:
                    assert i instanceof ItemStandard;
                    standardDetails.add((ItemStandard) i);
                    break;
            }
        }
        Collections.sort(standardDetails);
        Collections.sort(details);
        Collections.sort(materials);
        sortedList.addAll(standardDetails);
        sortedList.addAll(details);
        sortedList.addAll(materials);
        showList(sortedList);
    }

    private static void readResources() throws IOException {

        System.out.println("Reading from file..." + "\n");
        BufferedReader br = new BufferedReader(new FileReader("resources.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
                Item parseResult = Parser.parseItem(line);
                if (parseResult != null) {
                    unsortedItems.add(parseResult);
                } else {
                    System.out.println("...item is null...");
                }
                line = br.readLine();
            }
            showList(unsortedItems);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    private static void showList(List<Item> items) {
        for (Item a : items) {
            System.out.println(a);
        }
    }
}