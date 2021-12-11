public interface IPlayer {

    String getName();

    void placeShip();

    Shot takeShot();

    ShotResult receiveShot(Shot shot);

    void receiveShotResult(Shot shot, ShotResult result);

    Boolean allShipsSunk();
}
