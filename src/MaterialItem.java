
public class MaterialItem implements Item, Comparable<MaterialItem> {
    private final ItemType itemType;
    private final String designation;

    public MaterialItem(ItemType itemType, String designation) {
        this.itemType = itemType;
        this.designation = designation;
    }

    @Override
    public void parse(String designation) {
        //TODO
    }

    @Override
    public int compareTo(MaterialItem d) {

        int result = this.itemType.compareTo(d.getType());
        if (result == 0) {
            result = this.designation.compareTo(d.getDesignation());
        }
        return result;
    }

    @Override
    public String toString() {
        return itemType + ", " +
                designation;
    }

    public ItemType getType() {
        return itemType;
    }

    public String getDesignation() {
        return designation;
    }
}