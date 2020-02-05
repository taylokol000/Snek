public class Body {

    final int WIDTH=10,HEIGHT=10;
    int x,y;
    int speed=5,dx,dy;
    Snake snake;

    public Body(Snake snake,int length){
        this.snake=snake;
        x=snake.getX()+(10*length);
    }

}
