package actors;

import actors.Actor;
import actors.Obstacle;
import actors.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Scene extends JPanel implements ActionListener, MouseListener {

    private final ArrayList<Actor> actors = new ArrayList<>();

    private final int height;
    private final  int width ;
    private final double frameHeight;
    private final int speed;
    public Scene(int width, int height, double frameHeight, int speed){
        addMouseListener(this);
        this.height = height;
        this.width = width;
        this.frameHeight = frameHeight;
        this.speed = speed;
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    private void drawBackground(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setColor(Color.gray);
        g.fillRect(0,0, width, (int) (frameHeight* height));
        g.fillRect(0, (int) (height - (frameHeight* height)), width, (int) (frameHeight* height));

    }
    public double sceneWhiteFiled(){
        return height - frameHeight*height - frameHeight*height;
    }

    public int getLeftSensor(Position plane, int width, int height){
        return actors.stream()
                .filter(f -> (f instanceof Obstacle))
                .filter(f -> f.getPosition().getX() >= plane.getX() - ((Obstacle) f).WIDTH && f.getPosition().getX() <= plane.getX() + width  && f.getPosition().getY() + Obstacle.HEIGHT <= plane.getY() && f.getPosition().getY() >= frameHeight*this.height - height)
                .mapToInt(f -> (-1) * f.getPosition().getY())
                .sorted()
                .map(f -> (-1)*f + Obstacle.HEIGHT)
                .map(f -> plane.getY() - f)
                .findFirst()
                .orElse(plane.getY() - (int) (frameHeight* this.height));
    }
    public int getRightSensor(Position plane, int width, int height){
        return actors.stream()
                .filter(f -> (f instanceof Obstacle))
                .filter(f -> f.getPosition().getX() >= plane.getX() - ((Obstacle) f).HEIGHT && f.getPosition().getX() <= plane.getX() + width  && f.getPosition().getY() >= plane.getY() + height && f.getPosition().getY() <= (int) (this.height - (frameHeight* this.height)))
                .mapToInt(f -> f.getPosition().getY())
                .sorted()
                .map(f ->  f - (plane.getY() + height))
                .findFirst()
                .orElse((int) ((this.height - (frameHeight* this.height)) - plane.getY() - height));
    }
    public int getFrontSensor(Position plane, int width, int height){
        return actors.stream()
                .filter(f -> (f instanceof Obstacle))
                .filter(f -> f.getPosition().getX() >= plane.getX() && f.getPosition().getY() >= plane.getY() - ((Obstacle) f).HEIGHT  && f.getPosition().getY() - height <= plane.getY() )
                .mapToInt(f -> f.getPosition().getX())
                .sorted()
                .findFirst()
                .orElse( this.width) - (plane.getX());
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBackground(g);
        actors.forEach(a -> {
            a.nextStage(speed,this);
            a.paint(g);
            System.out.print(a.getPosition());
            System.out.print(" ");

        });

        System.out.println();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public double getFrameHeight() {
        return frameHeight;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        actors.add(new Obstacle(new Position(e.getX(),e.getY())));
    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
