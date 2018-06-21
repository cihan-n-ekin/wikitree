import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

                WikiInfo page = new WikiInfo(inp);

                // Do things to add to the tree

            } catch (IOException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
