import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    Game game;
    ArrayList<Body> body=new ArrayList<Body>();
    Snake snake;
    Food food;

    public Board(Game game){
        this.game=game;
        setPreferredSize(new Dimension(720,720));
        setBackground(Color.BLACK);
    }

    public void setup(){
        snake=new Snake(this);
        food=new Food(this);
        food.setX((int)(Math.random()*((getWidth()-food.getWIDTH())-0+1)+0));
        food.setY((int)(Math.random()*((getWidth()-food.getWIDTH())-0+1)+0));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        snake.paint(g);
        food.paint(g);
    }

}
