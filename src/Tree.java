import java.util.ArrayList;

public class Tree extends Node {
    public ArrayList<ArrayList<Node>> levels;

    Tree() {
        super("tree");
        levels = new ArrayList<>(6);
        this.level = 0;

        for (int i = 0; i < 6; i++) {
            levels.add(new ArrayList<Node>(0));
        }

    }

    public ArrayList<Node> getLevel(int lev) {
        return levels.get(lev);
    }


    public Node find(String id) {

        for( Node kingdom : getChildren()) {
            if(kingdom.id.equals(id)) return kingdom;
            for( Node phylum : getChildren()) {
                if(phylum.id.equals(id)) return phylum;
                for (Node c : getChildren()) {
                    if (c.id.equals(id)) return c;
                    for (Node d : getChildren()) {
                        if (d.id.equals(id)) return d;
                        for (Node g : getChildren()) {
                            if (g.id.equals(id)) return g;
                            for (Node s : getChildren()) {
                                if (s.id.equals(id)) return s;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void addSpecies(Species newSpecies) {

        // Kingdom
        String kingdom = newSpecies.taxon.kingdom.get("scientificName").getAsString();
        ArrayList<Node> kingdoms = getLevel(1);
        boolean newKingdomRequired = true;
        for (Node king:kingdoms) {
            if (kingdom.equals(king.id)) {
                newKingdomRequired = false;
            }

        }

        int firstLevel = 1;

        // TODO: SOME CODE!

        Node king = new Node("");
        Node phy = new Node("");
        Node ord = new Node("");
        Node clas = new Node("");
        Node fam = new Node("");
        Node genus = new Node("");
        Node spec = new Node("");

        switch(firstLevel){
            case 1:
                king.id = newSpecies.taxon.kingdom.get("scientificName").getAsString();
                this.addChild(king);

            case 2:
                phy.id = newSpecies.taxon.phylum.get("scientificName").getAsString();

                if (firstLevel < 2){
                    king.addChild(phy);
                } else {
                    Node newking = find(newSpecies.taxon.kingdom.get("scientificName").getAsString());
                    newking.addChild(phy);
                }

            case 3:
                subphy.id = newSpecies.taxon.subphylum.get("scientificName").getAsString();

                if (firstLevel < 3){
                    phy.addChild(subphy);
                } else {
                    Node newphy = find(newSpecies.taxon.phylum.get("scientificName").getAsString());
                    newphy.addChild(subphy);
                }

            case 4:
                ord.id = newSpecies.taxon.order.get("scientificName").getAsString();

                if (firstLevel < 3){
                    subphy.addChild(ord);
                } else {
                    Node newsubphy = find(newSpecies.taxon.subphylum.get("scientificName").getAsString());
                    newsubphy.addChild(ord);
                }

            case 5:
                subord.id = newSpecies.taxon.suborder.get("scientificName").getAsString();

                if (firstLevel < 3){
                    ord.addChild(subord);
                } else {
                    Node neword = find(newSpecies.taxon.order.get("scientificName").getAsString());
                    neword.addChild(subord);
                }

            case 6:
                clas.id = newSpecies.taxon.clss.get("scientificName").getAsString();

                if (firstLevel < 3){
                    subord.addChild(clas);
                } else {
                    Node newsubord = find(newSpecies.taxon.suborder.get("scientificName").getAsString());
                    newsubord.addChild(clas);
                }

            case 7:
                fam.id = newSpecies.taxon.family.get("scientificName").getAsString();

                if (firstLevel < 3){
                    clas.addChild(fam);
                } else {
                    Node newclas = find(newSpecies.taxon.clss.get("scientificName").getAsString());
                    newclas.addChild(fam);
                }

            case 8:
                genus.id = newSpecies.taxon.genus.get("scientificName").getAsString();

                if (firstLevel < 3){
                    fam.addChild(genus);
                } else {
                    Node newfam = find(newSpecies.taxon.family.get("scientificName").getAsString());
                    newfam.addChild(genus);
                }

            case 9:
                spec.id = newSpecies.taxon.species.get("scientificName").getAsString();

                if (firstLevel < 3){
                    genus.addChild(spec);
                } else {
                    Node newgenus = find(newSpecies.taxon.genus.get("scientificName").getAsString());
                    newgenus.addChild(spec);
                }
        }
    }
}
