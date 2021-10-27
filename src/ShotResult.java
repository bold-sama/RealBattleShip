public enum ShotResult {
    HIT,
    MISS,
    HITANDSUNK;

    private String shipName;
    private int length = 0;
    public int getLength(){
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setShipName(String name){
        this.shipName = name;
    }

    public String getShipName() {
        return shipName;
    }
}
