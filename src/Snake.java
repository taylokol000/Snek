import java.awt.*;

public class Snake {
    int x,y;
    final int WIDTH=10,HEIGHT=10;
    double speed,dx,dy;

    public Snake(Board board){
        x=board.getWidth()/2;
        y=board.getHeight()/2;
    }

    public void paint(Graphics g){
        g.setColor(new Color(46,139,87));
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
}
