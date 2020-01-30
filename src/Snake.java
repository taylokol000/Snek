public class Snake {
    int x,y;
    final int WIDTH=10,LENGTH=10;
    double speed,dx,dy;

    public Snake(Board board){
        x=board.getWidth()/2;
        y=board.getHeight()/2;
    }
}
