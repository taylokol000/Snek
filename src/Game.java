import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Board board;
    boolean upPressed,rightPressed,leftPressed,downPressed;

    public Game(){
        setTitle("Snake");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board=new Board(this);
        addKeyListener(this);
        add(board);
        pack();
        board.setup();
    }

    public static void main(String[] args){
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=false;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }
}
