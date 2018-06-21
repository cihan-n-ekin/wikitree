import java.util.ArrayList;

public class Tree extends Node {
    private ArrayList<ArrayList<Node>> levels;

    Tree() {
        super("tree");
        levels = new ArrayList<>(6);
    }

    public ArrayList<Node> getLevel(int lev) {
        return levels.get(lev);
    }

    public boolean find(Node node) {
        // TODO: Write method w
        return false;
    }

    public boolean find(String id) {
        // TODO: Write method w
        return false;
    }

    //TODO: add addSpecies() method

}
