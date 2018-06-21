import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Tree tree = new Tree();

        JFrame frame = new JFrame();

        while (true) {
            String inp = sc.next();
            if (inp.equals("exit")) {
                break;
            }
            try {

                TaxonomyInfo page = new TaxonomyInfo(inp);
                try {
                    System.out.print(page.phylum.get("scientificName").getAsString());
                    tree.addSpecies(new Species(page));
                    Render.render_win(frame, tree);
                } catch(NullPointerException e) {
                    System.out.println("not found!");
                    e.printStackTrace();
                }
                // Do things to add to the tree

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
