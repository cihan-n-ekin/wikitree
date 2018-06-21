import java.security.InvalidParameterException;

public class Species extends Node {

    public WikiInfo taxon;
    Tree tree;

    public Species(WikiInfo taxonInf) {
        super(taxonInf.species);

        taxon = taxonInf;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public Node getNodeOfLevel(int level) throws InvalidParameterException {
        if( !(level >= 5 || level <= 1)) {
            for (Node nodeToGet : tree.getLevel(level)) {
                if (nodeToGet.id.equals(this.taxon.getByTaxonLevel(level))) {
                    return nodeToGet;
                }
            }
        } else if (level == 1 ) {
            return this;
        }
        throw new InvalidParameterException();
    }

}
