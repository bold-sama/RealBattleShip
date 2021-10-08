public class Shot {
    private int row;
    private int column;

    /*
    |   the following logic has the rows signified by letters (starting with A),
    |   columns signified as numbers(starting with 1). Values start at the upper
    |   left corner of the grid.
     */
    public Shot(String humanValue) throws Exception{

        //normalize string
        String normailziedValue = humanValue.toLowerCase();

        //get the row from an attack
        row = rowFromHumanValue(normailziedValue);

        //get the column form the attack
        column = columnForHumanValue(normailziedValue);

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private int rowFromHumanValue(String value) throws Exception {
        //get the row from an attack
        char firstChar = value.charAt(0);
        row = (int)firstChar - 97;  //lower case ascii number
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
