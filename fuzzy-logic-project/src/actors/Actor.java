package actors;

public abstract class Actor implements Paintable {

    Position position;

    public Actor(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
    public void nextStage(int speed,Scene scene){

    }

}
