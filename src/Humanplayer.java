public class Humanplayer extends Player {

    public Humanplayer(String name) {
        super(name);
    }

    @Override
    public Shot takeShot(){
        //create local shot from user
        Shot shot = null;
        //show grids
        targetGrid.description();
        oceanGrid.description();
        while(true){
            String input = ConsoleHelper.getInput("enter shot");
            try{
                shot = new Shot(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            //no duplicate shots. can not take a shot that's been taken
            if(targetGrid.shotHasNotBeenMadeYet(shot)) {
                break;
            } else {
                System.out.printf("you have already taken a shot at %s%n",input);
            }
        } return shot;
    }

    @Override
    public ShotResult receiveShot(Shot shot) {
        return oceanGrid.receiveShot(shot);
    }

    @Override
    public void placeShip() {
        placeShipsRandomly();
    }
}
