import java.awt.*;

public class Food {

    int x,y;
    final int WIDTH=10,HEIGHT=10;

    public Food(Board board){
        x=board.getWidth()/3;
        y=board.getWidth()/3;
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}
