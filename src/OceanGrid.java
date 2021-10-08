public class OceanGrid {
    private Cell[][] cells = new Cell[10][10];

    public OceanGrid(){
        for(int x = 0; x < 10; x++){
            for (int y = 0; y <10; y++){
                cells[x][y] = new Cell();

            }
        }
    }
}
