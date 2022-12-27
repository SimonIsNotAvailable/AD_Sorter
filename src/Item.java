public class Item {
    private ItemType type;
    private String designation;

    public Item(ItemType type, String designation) {
        this.type = type;
        this.designation = designation;
    }

    public static Item parseItem(String line) {
        String[] parts = line.split(" ");
        if (parts.length > 2) {
            return new Item(ItemType.valueOf(parts[0]), line.substring(line.indexOf(" ") + 1));
        }
        return new Item(ItemType.valueOf(parts[0]), parts[1]);
    }

    @Override
    public String toString() {
        return type + ", " + designation;

    }

    public ItemType getType() {
        return type;
    }
}
