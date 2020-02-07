import java.awt.*;

public class Body {

    final int WIDTH=15,HEIGHT=15;
    int x,y;
    Snake snake;

    public Body(Snake snake){
        this.snake=snake;
        x=800;
        y=800;
    }

    public void moveY(int y){
        this.y=y;
    }

    public void moveX(int x){
        this.x=x;
    }

    public void paint(Graphics g){
        g.setColor(new Color(0,150,50));
        g.fillRect(x,y,WIDTH,HEIGHT);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }
}
