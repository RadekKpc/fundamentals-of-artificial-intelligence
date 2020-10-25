package actors;

import java.awt.*;

public class Obstacle extends Actor{

    public static final int HEIGHT = 30;
    public static final int WIDTH = 30;

    public Obstacle(Position position) {
        super(position);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect(position.getY(),position.getY(),WIDTH,HEIGHT);
    }
}
