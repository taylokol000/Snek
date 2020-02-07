import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Board board;
    boolean upPressed,rightPressed,leftPressed,downPressed,enterPressed,escPressed;

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
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            enterPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            escPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            if(downPressed==false) {
                upPressed = true;
                leftPressed = false;
                rightPressed = false;
                downPressed = false;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(rightPressed==false) {
                leftPressed = true;
                downPressed = false;
                rightPressed = false;
                upPressed = false;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(leftPressed==false) {
                rightPressed = true;
                leftPressed = false;
                downPressed = false;
                upPressed = false;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            if(upPressed==false) {
                downPressed = true;
                leftPressed = false;
                rightPressed = false;
                upPressed = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

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

    public boolean isEnterPressed() {
        return downPressed;
    }

    public boolean isEscPressed() {
        return downPressed;
    }
}
