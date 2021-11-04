public class brodyAIPlayer extends Player {

    public brodyAIPlayer() {
        super("USS Bold");
    }

    @Override
    public void placeShip() {
        placeShipsRandomly();
    }

    @Override
    public Shot takeShot() {
        return null;
    }

    @Override
    public ShotResult receiveShot(Shot shot) {
        return oceanGrid.receiveShot(shot);
    }
}
