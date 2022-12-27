public class Parser {
    private ItemType itemType;
    private Item item;

    public Parser(ItemType itemType, Item item) {
        this.itemType = itemType;
        this.item = item;
    }
     public void parse() {
        if(this.itemType == ItemType.DET) {
//            new Detail().parse();

            new Detail();
        }
     }
}
