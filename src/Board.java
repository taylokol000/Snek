import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    Game game;
    ArrayList<Body> body=new ArrayList<Body>();
    Snake snake;
    Food food;
    Timer timer;
    int score=0;

    public Board(Game game){
        this.game=game;
        setPreferredSize(new Dimension(720,720));
        setBackground(Color.BLACK);
        timer=new Timer(1000/60,this);
        timer.start();
    }

    public void setup(){
        snake=new Snake(this);
        food=new Food(this);
        food.randomSpawn();
    }

    public void checkCollisions(){
        if(snake.getBounds().intersects(food.getBounds())){
            food.randomSpawn();
            score++;
            body.add(new Body(snake,getBodies()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();

        if(game.isUpPressed()){
            snake.moveUp();
        }

        if(snake.getX()<=0){
            snake.setX(getWidth());
        }

        if(snake.getX()>=getWidth()+1){
            snake.setX(0);
        }

        if(snake.getY()<=0){
            snake.setY(getHeight());
        }

        if(snake.getY()>=getHeight()+1){
            snake.setY(0);
        }

        if(game.isDownPressed()){
            snake.moveDown();
        }

        if(game.isRightPressed()){
            snake.moveRight();
        }

        if(game.isLeftPressed()){
            snake.moveLeft();
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        snake.paint(g);
        food.paint(g);
    }

    public int getBodies(){
        return body.size();
    }
}
