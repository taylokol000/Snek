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
        timer=new Timer(1000/30,this);
        timer.start();
    }

    public void setup(){
        snake=new Snake(this);
        body.add(new Body(snake));
        food=new Food(this);
        food.randomSpawn();
    }

    public void checkCollisions(){
        if(snake.getBounds().intersects(food.getBounds())){
            food.randomSpawn();
            score++;
            body.add(new Body(snake));
            snake.setSpeed(.1);
            score++;
        }
        for(int i=0;i<body.size();i++){
            if(snake.getBounds().intersects(body.get(i).getBounds())){
                System.out.println("Death");
                GameStates.setDEATH(true);
                GameStates.setPLAY(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.isEnterPressed()){
            GameStates.setMENU(false);
            GameStates.setDEATH(false);
            GameStates.setPLAY(true);
            game.setRightPressed(true);
            score=0;
        }

        if(GameStates.isDEATH()){
            for(int i=1;i<body.size();i++){
                body.remove(i);
            }
        }

        if(GameStates.isPLAY()) {
            checkCollisions();

            for (int i = body.size() - 1; i >= 0; i--) {
                if (i > 0) {
                    body.get(i).moveX(body.get(i - 1).getX());
                    body.get(i).moveY(body.get(i - 1).getY());
                } else {
                    body.get(i).moveX(snake.getX());
                    body.get(i).moveY(snake.getY());
                }
            }

            if (game.isUpPressed()) {
                snake.moveUp();
            }

            if (snake.getX() <= 0) {
                snake.setX(getWidth());
            }

            if (snake.getX() >= getWidth() + 1) {
                snake.setX(0);
            }

            if (snake.getY() <= 0) {
                snake.setY(getHeight());
            }

            if (snake.getY() >= getHeight() + 1) {
                snake.setY(0);
            }

            if (game.isDownPressed()) {
                snake.moveDown();
            }

            if (game.isRightPressed()) {
                snake.moveRight();
            }

            if (game.isLeftPressed()) {
                snake.moveLeft();
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(GameStates.isMENU()){
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial",Font.PLAIN,72));
            printSimpleString("Snek",getWidth(),0,100,g);
            g.setFont(new Font("Arial",Font.PLAIN,36));
            printSimpleString("Press enter to start!",getWidth(),0,300,g);
        }

        if(GameStates.isPLAY()) {
            snake.paint(g);
            food.paint(g);
            for (Body body : body) {
                body.paint(g);
            }
        }

        if(GameStates.isDEATH()){
            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,36));
            printSimpleString("You died with a score of "+score+"!",getWidth(),0,100,g);
            g.setFont(new Font("Arial",Font.PLAIN,36));
            printSimpleString("Press enter to play again!",getWidth(),0,300,g);
        }
    }

    private void printSimpleString(String s,int width,int XPos,int YPos,Graphics g){
        int stringLen=(int)g.getFontMetrics().getStringBounds(s,g).getWidth();
        int start=width/2-stringLen/2;
        g.drawString(s,start+XPos,YPos);
    }
}
