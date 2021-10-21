import java.awt.*;

public class TargetGrid {
   protected Cell[][] cells;
    public TargetGrid(){
        //instances grid
        cells = new Cell[10][10];
        for(int x = 0; x < 10; x++){
            for (int y = 0; y <10; y++){
                cells[x][y] = new Cell();
            }
        }
    }

    //return target cell at a given point
    public Cell cellAtPoint(Point givenPoint){

        return cells[givenPoint.x][givenPoint.y];
    }


    public Boolean shotHasNotBeenMadeYet(Shot shot){
        Point shotPoint = shot.getLocation();
        Cell cell = cellAtPoint(shotPoint);
        CellState state = cell.getState();
        if (state == CellState.EMPTY){
            return true;
        }
        else return false;
    }

    public void description(){
        // print out console header representation of the grid
        printHeader();
        for(int row = 0; row < 10; row++){
            printRow(row);
        }
    }
    private void printRow(int rowNumber){
        char letter = (char)(rowNumber + 65);
        System.out.print("| " + letter + " |");
        for(int column = 0; column < 10; column++){
            switch(cellAtPoint(new Point(column, rowNumber)).getState()){
                case EMPTY -> System.out.print("   .");
                case HIT -> System.out.print(" * .");
                case MISS -> System.out.print(" o .");
                case OCCUPIED -> System.out.print(" # .");
            }
        }
        System.out.printf("%n");
    }

    private void printHeader(){
        printBorder();
        System.out.print("|   |");
        for(int column = 1; column < 11; column++){
            System.out.printf("%2d", column);
            System.out.print(" |");
        }
        System.out.printf("%n");
        printBorder();
    }

    private void printBorder(){
        // blank column
        System.out.print("+---+");
        // letter columns
        for(int column = 0; column < 10; column++){
            System.out.print("---+");
        }
        System.out.printf("%n");
    }
}
