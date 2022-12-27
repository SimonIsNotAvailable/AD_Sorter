public class Parser {

    public static Item parseItem(String line) {

        String[] parts = line.split(" ");
        ItemType lineType = ItemType.valueOf(parts[0]);

        if (lineType == ItemType.DET || lineType == ItemType.SE) {
            return new ItemDetail(lineType, parts[1]);
        }

        if (parts.length > 2 || lineType == ItemType.MAT) {
            return new MaterialItem(lineType, line.substring(line.indexOf(" ") + 1));
        }

        if (lineType == ItemType.STD) {
            return new ItemStandard(lineType, parts[1]);
        }
        return null;
    }
}