import javax.lang.model.type.NullType;
import java.util.ArrayList;

import static java.util.Objects.isNull;

public class Node {

    private ArrayList<Node> children;

    private int x = 0;
    private int y = 0;

    public int level;
    /*
    LEVELS:
        0: root (Tree instance)
        1: Kingdom
        2: Order
        3: Family
        4: Genus
        5: Species (Species instance)
     */
    public String id;

    public Node(String id) {
        children = new ArrayList<>(0);
    }


    public void addChild(Node newChild) {
        // Assumes this is correctly formatted to be a child of this node!!

        // Add child to children ArrayList
        if (isNull(getChild(newChild.id))) {
            children.add(newChild);
        }
    }

    public Node getChild(String id) {
        for (Node child : children) {
            if(id.equals(child.id)) {
                return child;
            }
        }
        return null;
    }

    public Node[] getChildren() {
        return children.toArray(new Node[0]);
    }

    public int[] setCoordinates() {
        int[] coord = new int[2];
        coord[0] = x;
        coord[1] = y;
        return coord;
    }
}
