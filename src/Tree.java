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
        JsonElement kingdom = newSpecies.taxon.kingdom.get("scientificName");
        ArrayList<Node> kingdoms = getLevel(1);
        boolean newKingdomRequired = true;
        for (Node king:kingdoms) {
            if (kingdom.getAsString() == king.id) {
                newKingdomRequired = false;
            }

        }

        int firstLevel = 1;



        switch(firstLevel){
            case 1:
                String kingname = newSpecies.taxon.kingdom.get("scientificName").getAsString();
                Node king = new Node(kingname);
            case 2:
                String phyname = newSpecies.taxon.phylum.get("scientificName").getAsString();
                Node phy = new Node(phyname);
            case 3:
                String subphyname = newSpecies.taxon.subphylum.get("scientificName").getAsString();
                Node subphy = new Node(subphyname);
            case 4:
                String ordname = newSpecies.taxon.order.get("scientificName").getAsString();
                Node ord = new Node(ordname);
            case 5:
                String subordname = newSpecies.taxon.suborder.get("scientificName").getAsString();
                Node subord = new Node(subordname);
            case 6:
                String clasname = newSpecies.taxon.clss.get("scientificName").getAsString();
                Node clas = new Node(clasname);
            case 7:

        }



                String specname = newSpecies.taxon.species.get("scientificName").getAsString();
        String genusname = newSpecies.taxon.genus.get("scientificName").getAsString();
        String famname = newSpecies.taxon.family.get("scientificName").getAsString();





        Node spec = new Node(specname);
        Node genus = new Node(genusname);
        Node fam  = new Node(famname);







        genus.addChild(spec);
        fam.addChild(genus);
        clas.addChild(fam);
        subord.addChild(clas);
        ord.addChild(subord);
        subphy.addChild(ord);
        phy.addChild(subphy);
        king.addChild(phy);
        this.addChild(king);



    }


}
