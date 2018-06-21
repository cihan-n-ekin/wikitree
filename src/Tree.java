import java.util.ArrayList;

public class Tree extends Node {
    public ArrayList<ArrayList<Node>> levels;

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

    public Node find(String id) {
        // TODO: Write method w
        return new Node("w");
    }

    public void addSpecies(Species newSpecies) {
        //TODO: add addSpecies() method
    }


}
