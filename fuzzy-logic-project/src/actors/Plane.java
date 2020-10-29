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
        System.out.println();
        double leftSensor = (double) scene.getLeftSensor(position, WIDTH, HEIGHT) /  scene.sceneWhiteFiled() * 100;
        double rightSensor = scene.getRightSensor(position, WIDTH, HEIGHT) / ( scene.sceneWhiteFiled()) * 100;
        double frontSensor = (double) scene.getFrontSensor(position, WIDTH, HEIGHT) / (scene.getWidth() - position.getX() - WIDTH) * 100;

        System.out.println(leftSensor);
        System.out.println(rightSensor);
        System.out.println(frontSensor);
//        Variable howToChange = fuzzyDriver.calculate(frontSensor,rightSensor,leftSensor);
//        System.out.println(howToChange.getValue());
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
}
