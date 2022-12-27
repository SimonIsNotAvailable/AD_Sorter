
public class MaterialItem implements Item, Comparable<MaterialItem> {
    private final ItemType itemType;
    private String designation;

    public MaterialItem(ItemType itemType, String designation) {
        this.itemType = itemType;
        parse(designation);
    }

    @Override
    public void parse(String designation) {
        if (designation.length() > 128) {
            throw new IndexOutOfBoundsException("Material name is too long");
        } else {
            this.designation = designation;
        }
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