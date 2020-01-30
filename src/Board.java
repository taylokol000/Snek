import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    Game game;
    ArrayList<Snake> snake=new ArrayList<Snake>();

    public Board(Game game){
        this.game=game;
        setPreferredSize(new Dimension(720,720));
        setBackground(Color.BLACK);
    }

    public void setup(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
