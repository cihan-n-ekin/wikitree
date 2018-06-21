import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WikiInfo {
    public ArrayList<String> clades;
    public String kingdom;
    public String order;
    public String family;
    public String genus;
    public String species;

     WikiInfo(String url) throws IOException, IllegalArgumentException{

        Document doc = Jsoup.connect(url).get();
        System.out.println(doc.title());

        /*
        TODO: 21/06/2018 Check if this is a wikipedia article of a species.
        Throw IllegalArgumentException if it isn't.
        */

        if (false) {
            throw new IllegalArgumentException();
        }

        Elements infoboxes = doc.select(".infobox.biota");

        for (Element box : infoboxes ) {
            Elements rows = box.child(0).children();
            for (Element row : rows) {

                Elements cols = row.children();

                if (cols.size() == 2) {
                    switch(cols.get(0).text()) {
                        case "Kingdom":
                            kingdom = cols.get(0).text();
                            break;
                        case "Order:":
                            order = cols.get(0).text();
                            break;
                        case "Family:":
                            family = cols.get(0).text();
                            break;
                        case "Genus:":
                            genus = cols.get(0).text();
                            break;
                        case "Species:":
                            species = cols.get(0).text();
                            break;
                        case "Clade:":
                            clades.add(cols.get(0).text());
                            break;
                    }
                }
            }
        }
    }

    public String getByTaxonLevel(int level) {
         switch (level) {
             case 1: return kingdom;
             case 2: return order;
             case 3: return family;
             case 4: return genus;
             case 5: return species;
             default: return null;
         }
    }
}
