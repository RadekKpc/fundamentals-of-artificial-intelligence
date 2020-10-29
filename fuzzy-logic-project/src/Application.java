import actors.Plane;
import actors.Position;
import actors.Scene;

import javax.swing.*;

public class Application extends  Thread {

    public static void main(String[] args) throws InterruptedException {
        Scene scene = new Scene(800,800,0.3,1);
        Timer timer = new Timer(1000,scene);

        scene.addActor(new Plane(new Position(10,scene.getHeight()/2), 2));


        JFrame frame = new JFrame("Fuzzy Logic Plane Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 800);
        frame.add(scene);
        frame.setVisible(true);

        timer.start();

    }

}
