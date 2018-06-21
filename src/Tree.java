import com.google.gson.JsonElement;

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
        // TODO: Write method w
        return false;
    }

    public Node find(String id) {
        // TODO: Write method w
        return new Node("w");
    }

    public void addSpecies(Species newSpecies) {

        // Kingdom
        String kingdom = newSpecies.taxon.kingdom.get("scientificName").getAsString();
        ArrayList<Node> kingdoms = getLevel(1);
        boolean newKingdomRequired = true;
        for (Node king:kingdoms) {
            if (kingdom == king.id) {
                newKingdomRequired = false;
            }

        }

        int firstLevel = 1;

        Node king = new Node("");
        Node phy = new Node("");
        Node subphy = new Node("");
        Node ord = new Node("");
        Node subord = new Node("");
        Node clas = new Node("");
        Node fam = new Node("");
        Node genus = new Node("");
        Node spec = new Node("");

        switch(firstLevel){
            case 1:
                String kingname = newSpecies.taxon.kingdom.get("scientificName").getAsString();
                king.id = kingname;
                this.addChild(king);
            case 2:
                String phyname = newSpecies.taxon.phylum.get("scientificName").getAsString();
                phy.id = phyname;

                if (firstLevel < 2){
                    king.addChild(phy);
                } else {
                    Node newking = find(newSpecies.taxon.kingdom.get("scientificName").getAsString());
                    newking.addChild(phy);
                }

            case 3:
                String subphyname = newSpecies.taxon.subphylum.get("scientificName").getAsString();
                subphy.id = subphyname;

                if (firstLevel < 3){
                    phy.addChild(subphy);
                } else {
                    Node newphy = find(newSpecies.taxon.phylum.get("scientificName").getAsString());
                    newphy.addChild(subphy);
                }

            case 4:
                String ordname = newSpecies.taxon.order.get("scientificName").getAsString();
                ord.id = ordname;

                if (firstLevel < 3){
                    subphy.addChild(ord);
                } else {
                    Node newsubphy = find(newSpecies.taxon.subphylum.get("scientificName").getAsString());
                    newsubphy.addChild(ord);
                }

            case 5:
                String subordname = newSpecies.taxon.suborder.get("scientificName").getAsString();
                subord.id = subordname;

                if (firstLevel < 3){
                    ord.addChild(subord);
                } else {
                    Node neword = find(newSpecies.taxon.order.get("scientificName").getAsString());
                    neword.addChild(subord);
                }

            case 6:
                String clasname = newSpecies.taxon.clss.get("scientificName").getAsString();
                clas.id = clasname;

                if (firstLevel < 3){
                    subord.addChild(clas);
                } else {
                    Node newsubord = find(newSpecies.taxon.suborder.get("scientificName").getAsString());
                    newsubord.addChild(clas);
                }

            case 7:
                String famname = newSpecies.taxon.family.get("scientificName").getAsString();
                fam.id = famname;

                if (firstLevel < 3){
                    clas.addChild(fam);
                } else {
                    Node newclas = find(newSpecies.taxon.clss.get("scientificName").getAsString());
                    newclas.addChild(fam);
                }

            case 8:
                String genusname = newSpecies.taxon.genus.get("scientificName").getAsString();
                genus.id = genusname;

                if (firstLevel < 3){
                    fam.addChild(genus);
                } else {
                    Node newfam = find(newSpecies.taxon.family.get("scientificName").getAsString());
                    newfam.addChild(genus);
                }

            case 9:
                String specname = newSpecies.taxon.species.get("scientificName").getAsString();
                spec.id = specname;

                if (firstLevel < 3){
                    genus.addChild(spec);
                } else {
                    Node newgenus = find(newSpecies.taxon.genus.get("scientificName").getAsString());
                    newgenus.addChild(spec);
                }
        }
    }
}
