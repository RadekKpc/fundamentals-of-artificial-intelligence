package actors;

import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.awt.*;

public class Plane extends Actor{

    public static final int HEIGHT = 30;
    public static final int WIDTH = 100;

    private int leftSensor;
    private int rightSensor;
    private int frontSensor;
    private final int speed;

    private FuzzyDriver fuzzyDriver;

    public Plane(Position position,int speed) {
        super(position);
        this.speed = speed;
        fuzzyDriver = new FuzzyDriver();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(position.getX(),position.getY(),WIDTH,HEIGHT);
    }

    public void moveUp(){
        this.position.setY(position.getY() - speed);

    }
    public void moveDown(){
        this.position.setY(position.getY() + speed);
    }
    @Override
    public void nextStage(int speed,Scene scene){
        System.out.println(scene.getLeftSensor(position, WIDTH, HEIGHT));
        System.out.println(scene.getRightSensor(position, WIDTH, HEIGHT));
        System.out.println(scene.getFrontSensor(position, WIDTH, HEIGHT));
//        Variable howToChange = fuzzyDriver.calculate(position);
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
