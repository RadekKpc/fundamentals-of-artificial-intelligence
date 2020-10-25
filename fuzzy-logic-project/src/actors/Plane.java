package actors;

import java.awt.*;
import java.awt.font.GraphicAttribute;

public class Plane extends Actor{

    public static final int HEIGHT = 30;
    public static final int WIDTH = 100;

    private int leftSensor;
    private int rightSensor;
    private int frontSensor;
    public Plane(Position position) {
        super(position);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(position.getX(),position.getY(),WIDTH,HEIGHT);
    }
}
