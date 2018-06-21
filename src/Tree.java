import java.util.ArrayList;

public class Tree extends Node {
    public ArrayList<ArrayList<Node>> levels;

    Tree() {
        super("tree");
        levels = new ArrayList<>(6);
        this.level = 0;
    }

    public ArrayList<Node> getLevel(int lev) {
        return levels.get(lev);
    }

    public boolean find(Node node) {
        ArrayList<Node> searchNodes = new ArrayList<>(1);
        ArrayList<Node> newSearchNodes = new ArrayList<>(0);
        searchNodes.set(1, this);



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
