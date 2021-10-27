import java.awt.Point;
public class Shot {
    private Point location; // x is column and y is row

    /*
    |   the following logic has the rows signified by letters (starting with A),
    |   columns signified as numbers(starting with 1). Values start at the upper
    |   left corner of the grid.
     */
    public Shot(String humanValue) throws Exception{

        //normalize string
        String normailziedValue = humanValue.toLowerCase();

        //get the row from an attack
        int row = rowFromHumanValue(normailziedValue);

        //get the column form the attack
        int column = columnForHumanValue(normailziedValue);

        location = new Point(column, row);

    }

    public Shot(Point point) throws Exception{
        if(point.x < 0 || point.x > 9){
            throw new Exception("invalid column");
        }
        if (point.y < 0 || point.y > 9){
            throw new Exception("invalid row");
        }
    }

    public int getRow() {
        return location.y;
    }

    public int getColumn() {
        return location.x;
    }

    public Point getLocation() {
        return location;
    }

    public String getDescription(){
        char firstLetter = (char)(location.y + 97);
        String assembled = Character.toString(firstLetter) + Integer.toString(location.x +1);
        return assembled;
        }

    private int rowFromHumanValue(String value) throws Exception {
        //get the row from an attack
        char firstChar = value.charAt(0);
        int row = (int)firstChar - 97;  //lower case ascii number
        if (row > 9 || row < 0){
            throw new Exception("invalid Row");
        }
        return row;
    }

    private int columnForHumanValue(String value) throws Exception{
        String columnvalue = value.substring(1);
        int column;
        try {
            column = Integer.parseInt(columnvalue);
        } catch (NumberFormatException e) {
            throw new Exception("invalid column for shot.");
        }
        column -= 1; // switch from 1-index to 0-index
        if (column > 9 || column < 0){
            throw new Exception("invalid Column");
        }
        return column;
    }
}
