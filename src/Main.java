import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String inp = sc.next();
            if (inp.equals("exit")) {
                break;
            }
            try {

                TaxonomyInfo page = new TaxonomyInfo(inp);

                // Do things to add to the tree

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
