public class ItemDetail implements Item, Comparable<ItemDetail> {
    private final ItemType itemType;
    private String detailNumber;
    private String systemNumber;
    private String partNumber;

    public ItemDetail(ItemType itemType, String designation) {
        this.itemType = itemType;
        parse(designation);
    }

    @Override
    public void parse(String designation) {
        String[] parts = designation.split("-");
        this.detailNumber = parts[0];
        this.systemNumber = parts[1];
        this.partNumber = parts[2];
    }

    @Override
    public int compareTo(ItemDetail d) {

        int result = this.itemType.compareTo(d.getType());

        if (result == 0){
            result = this.systemNumber.compareTo(d.getSystemNumber());
        }
        if (result == 0) {
            result = this.detailNumber.compareTo(d.getDetailNumber());
        }
        if (result == 0) {
            result = this.partNumber.compareTo(d.getPartNumber());
        }
        return result;
    }

    @Override
    public String toString() {
        return itemType + ", " +
                detailNumber + "-" +
                systemNumber + "-" +
                partNumber;
    }

    public String getDetailNumber() {
        return detailNumber;
    }

    public String getSystemNumber() {
        return systemNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public ItemType getType() {
        return itemType;
    }
}
