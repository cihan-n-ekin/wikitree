import java.util.ArrayList;

public class Node {

    private ArrayList<Node> children;
    public int level;
    /*
    LEVELS:
        0: root (Tree instance)
        1! Domain
        1: Kingdom
        2: Order
        3: Family
        4: Genus
        5: Species (Species instance)
     */
    public String id;

    Node() {

    }

    public void addChild() {
        // Add child to children ArrayList
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}
