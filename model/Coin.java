package model;


public class Coin  {
    public static final int SIZE = 50;
    private static final int INITIAL_Y = 50;
    private static final int MOVE = 4;

    public static final int Y = 600;
    private int score;
    private int x;
    private int y;

    public Coin(int startX, int y){
        x = startX;
        this.y = y;
        this.score = 150;
    }

    public boolean descend(){
        y += MOVE;
        return y >= TropelGame.MAP_SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
