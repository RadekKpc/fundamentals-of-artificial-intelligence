import actors.Actor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Scene extends JPanel implements ActionListener {

    private final ArrayList<Actor> actors = new ArrayList<>();

    private final int height;
    private final  int width ;
    private final double frameHeight;

    public Scene(int width, int height, double frameHeight) {
        this.height = height;
        this.width = width;
        this.frameHeight = frameHeight;
    }

    public void addActor(Actor actor){
        actors.add(actor);
    }

    private void drawBackground(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0,0, width, (int) (frameHeight* height));
        g.fillRect(0, (int) (height - (frameHeight* height)), width, (int) (frameHeight* height));
    }

    @Override
    public void paintComponent(Graphics g) {
        drawBackground(g);
        actors.forEach(a -> {
            a.paint(g);
            System.out.println(a.getPosition());

        });
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
}
