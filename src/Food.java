import java.awt.*;

public class Food {

    int x,y;
    final int WIDTH=15,HEIGHT=15;
    Board board;

    public Food(Board board){
        x=board.getWidth()/3;
        y=board.getWidth()/3;
        this.board=board;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,HEIGHT,WIDTH);
    }

    public void randomSpawn(){
        setX((int)(Math.random()*((board.getWidth()-getWIDTH())+1)+0));
        setY((int)(Math.random()*((board.getWidth()-getWIDTH())+1)+0));
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
