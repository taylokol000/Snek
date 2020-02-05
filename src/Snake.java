import java.awt.*;

public class Snake {
    int x,y;
    final int WIDTH=10,HEIGHT=10;
    double speed=5,dx,dy;

    public Snake(Board board){
        x=board.getWidth()/2;
        y=board.getHeight()/2;
        dx=speed;
        dy=speed;
    }

    public void moveUp(){
        y-=dx;
    }

    public void moveDown(){
        y+=dx;
    }

    public void moveLeft(){
        x-=dy;
    }

    public void moveRight(){
        x+=dy;
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

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    public void paint(Graphics g){
        g.setColor(new Color(46,139,87));
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
}
