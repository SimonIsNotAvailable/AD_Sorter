public class ItemStandard implements Item, Comparable<ItemStandard> {
    private final ItemType itemType;
    private String serialNumber;
    private String registrationNumber;
    private String modificationNumber;
    private String sizeNumber;

    public ItemStandard(ItemType itemType, String designation) {
        this.itemType = itemType;
        parse(designation);
    }

    @Override
    public void parse(String designation) {

        String[] parts = designation.split("-");
        this.serialNumber = parts[0];
        this.registrationNumber = parts[1];
        this.modificationNumber = parts[2];

        if (parts.length > 3) {
            this.sizeNumber = parts[3];
        }
    }

    public int compareTo(ItemStandard d) {

        int result = this.itemType.compareTo(d.getType());
        if(result == 0) {
            result = this.registrationNumber.compareTo(d.getRegistrationNumber());
        }
        if (result == 0) {
            result = this.modificationNumber.compareTo(d.getModificationNumber());
        }
        if (result == 0) {
            result = this.sizeNumber.compareTo(d.getSizeNumber());
        }
        return result;
    }

    @Override
    public String toString() {
        String returnString = itemType + ", " + serialNumber + "-" +
                registrationNumber + "-" +
                modificationNumber;
        if (sizeNumber == null) {
            return returnString;
        } else return returnString + "-" +
                sizeNumber;
    }

    public ItemType getType() {
        return itemType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModificationNumber() {
        return modificationNumber;
    }

    public String getSizeNumber() {
        return sizeNumber;
    }
}