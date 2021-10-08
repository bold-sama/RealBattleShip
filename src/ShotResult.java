public enum ShotResult {
    HIT,
    MISS,
    HITANDSUNK;

    private int length = 0;
    public int getLength(){
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
