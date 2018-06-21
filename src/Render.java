import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Render {

    private static JPanel[] renderTaxonomy(Tree tree, int level){

        ArrayList<Node> levelElems = tree.getLevel(level);
        int numOfElems = levelElems.size();

        int numOfNextLevelElems = 0;
        int weight;

        if (level != 6) {
            numOfNextLevelElems = tree.getLevel(level + 1).size();
        }

        if (numOfNextLevelElems == 0) {
            weight = 700 / numOfElems;
        } else {
            weight = 700 / numOfNextLevelElems;
        }

        JPanel[] panelArray = new JPanel[numOfElems];

        for (int i = 0; i < numOfElems; i++){
            JPanel elemPanel = new JPanel();
            Node elem = levelElems.get(i);

            int prevNumOfChildren = 0;
            if (i != 0){
                prevNumOfChildren = levelElems.get(i - 1).getChildren().length;
            }

            int numOfChildren = elem.getChildren().length;
            int height = weight * numOfChildren;

            elemPanel.setBounds(0, weight * prevNumOfChildren, 137, height);

            String name = elem.id;
            JLabel label = new JLabel(name);
            label.setBounds(68, height/2, 130, 60);
            elem.x = (i * 137) + 68;
            elem.y = ((weight * prevNumOfChildren) + height);
            elemPanel.add(label);

            panelArray[i] = elemPanel;
        }

        return panelArray;
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        JFrame frame = new JFrame();

        // Taxonomy elements are panels
        String[] taxonomy = new String[9];
        taxonomy[0] = "Kingdom";
        taxonomy[1] = "Phylum";
        taxonomy[2] = "SubPhylum";
        taxonomy[3] = "Class";
        taxonomy[4] = "Order";
        taxonomy[5] = "SubOrder";
        taxonomy[6] = "Family";
        taxonomy[7] = "Genus";
        taxonomy[8] = "Species";

        // Sizes
        int lenghtOfTaxonomy = taxonomy.length;
        int widthOfBox = 137;
        int heightOfWindow = 800;
        int widthOfWindow = lenghtOfTaxonomy * widthOfBox

        for (int i = 0; i < lenghtOfTaxonomy; i++) {
            JPanel taxopanel = new JPanel();

            taxopanel.setBounds(i * widthOfBox, 0, widthOfBox, 600);
            taxopanel.setBackground(Color.getHSBColor(i * 15, i * 15, 180));

            JLabel taxoLabel = new JLabel(taxonomy[i]);

            // JPanel[] insidePanelArray = renderTaxonomy(tree,1);

            /*for (JPanel insidePanel : insidePanelArray) {
                taxopanel.add(insidePanel);
            }*/

            taxopanel.add(taxoLabel);
            frame.add(taxopanel);
        }

        // TODO: Generate lines

        // Search GUI
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(0, 600, widthOfWindow, 200);

        JButton searchButton = new JButton("Search");
        JTextField searchField = new JTextField("Name");

        searchField.setBounds(200, 50, 100, 20);
        searchButton.setBounds(450, 50, 100, 20);

        searchPanel.setBackground(Color.gray);

        searchPanel.add(searchButton);
        searchPanel.add(searchField);

        frame.add(searchPanel);

        frame.setSize(widthOfWindow, heightOfWindow);
        frame.setLayout(null);

        frame.setVisible(true);
    }
}

